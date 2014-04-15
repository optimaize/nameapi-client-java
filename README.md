nameapi-client-java
===================

Java Client for the NameAPI Web Service at http://www.nameapi.org/

There are functional tests (in test/functional) that demonstrate how to use this library.

All you need to send requests is your own api key, get it from nameapi.org.

This library requires at least Java 7.



## Library setup

Using maven:

    <dependency>
      <groupId>org.nameapi.client</groupId>
      <artifactId>nameapi-client</artifactId>
      <version>0.1-SNAPSHOT</version>
    </dependency>

Or you can download the jar, or check out the source code from this GitHub project.



## Setup code

At first you need one single include, the one to the nameapi service factory:


You need a Context that explains a bit your working environment, something like:

```java
Context context = new ContextBuilder()
    .apiKey("your-api-key")
    .priority(Priority.REALTIME)
    .build();
```

Then you need an executor and a mode:

```java
CommandExecutor executor = NameApiRemoteExecutors.get()
Mode mode = NameApiModeFactory.minimal(context);
```

Now you're ready to execute commands.




## Send a ping

This code sends a simple ping to nameapi to test the connection:

```java
PingerCommand command = new PingerCommand();
executor.execute(command, mode, null).get().getPong(); //returns "pong"
```



## Input / Output

All input objects come with builders or nicely documented setters.
The result objects returned by the services all have fully documented getters.
Many input arguments are optional - that means you can start simple, and add more as you need.

Behind the scenes this service api uses SOAP. But luckily you don't need to worry about any
of the interface detail, you can just use the provided classes.
The complexity of some of the objects is the reason why SOAP was chosen over REST.

#### Person input object

Most services accept a 'Person' as input. This person contains a name, and optionally
more data such as gender, birth date etc.
The name can be just a single "full name" string, or it can be composed of multiple
fields like given name, middle name, surname.
This standardized api makes it simple to use different services in a consistent way,
and is very convenient in accepting the data however you have it at hands.

Creating a simple person looks something like this:

```java
InputPersonName name = NameBuilders.western().fullname("John F. Kennedy").build();
InputPerson inputPerson = new NaturalInputPersonBuilder().name(name).build();
```



## Commands

The web service methods are implemented as commands. This brings the advantage that the
command can be passed around and wrapped with other useful goodies such as logging
in a unified way, without the need to put a wrapper around every service.
For more specialized concerns such as auto-retry on failure this concept becomes
a real advantage.



## Name Parser

Name parsing is the process of splitting a full name into its components.

Using the objects created earlier:

```java
PersonNameParserCommand command = new PersonNameParserCommand();
PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
```


## Name Genderizer

Name genderizing is the process of identifying the gender based on a person's name.

Using the objects created earlier:

```java
PersonGenderizerCommand command = new PersonGenderizerCommand();
PersonGenderizerResult result = executor.execute(command, mode, inputPerson).get();
```


## Name Matcher

The Name Matcher compares names and name pairs to discover whether the people could possibly be one and the same person.

This service takes 2 people as input:

```java
PersonMatcherCommand command = new PersonMatcherCommand();
NaturalInputPerson person1 = new NaturalInputPersonBuilder().name( NameBuilders.western().fullname("John F. Kennedy").build() ).build();
NaturalInputPerson person2 = new NaturalInputPersonBuilder().name( NameBuilders.western().fullname("Jake Kennedy").build() ).build();
PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
PersonMatcherResult result = executor.execute(command, mode, argument).get();
```


## Name Formatter

The Name Formatter displays personal names in the desired form. This includes the order as well as upper and lower case writing.

```java
PersonNameFormatterCommand command = new PersonNameFormatterCommand();
NaturalInputPerson person = new NaturalInputPersonBuilder().name( NameBuilders.western().fullname("john f. kennedy").build() ).build();
FormatterProperties properties = new FormatterPropertiesBuilder().build();
PersonNameFormatterArgument argument = new PersonNameFormatterArgument(person, properties);
FormatterResult formatterResult = executor.execute(command, mode, argument).get();
```


## Email Name Parser

The Email Name Parser extracts names out of email addresses.

```java
EmailNameParserCommand command = new EmailNameParserCommand();
EmailNameParserResult result = executor.execute(command, mode, "john.doe@example.com").get();
```


## Disposable Email Address Detector

The DEA-Detector checks email addresses against a list of known "trash domains" such as mailinator.com.

```java
DisposableEmailAddressDetectorCommand command = new DisposableEmailAddressDetectorCommand();
DisposableEmailAddressDetectorResult result = executor.execute(command, mode, "blahblah@10minutemail.com");
```

