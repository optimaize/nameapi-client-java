nameapi-client-java
===================

Java Client for the NameAPI Web Services at https://www.nameapi.org.

There are functional tests that demonstrate how to use this library.

All you need to send requests is your own api key which you can get from nameapi.org.

This library requires at least Java 17 starting from version 6.0.0 (use a previous version for Java 8).



## Library setup

Using Maven:

    <dependency>
      <groupId>org.nameapi.client</groupId>
      <artifactId>nameapi-client</artifactId>
      <version>6.0.0</version>
    </dependency>
    
Or Gradle:

    implementation 'org.nameapi.client:nameapi-client:6.0.0'

Also you could download the jar, or check out the source code from this GitHub project.



## Setup code

At first, you need some includes, to the context information:

```java
import org.nameapi.ontology5.input.context.Context;
import org.nameapi.ontology5.input.context.ContextBuilder;
import org.nameapi.ontology5.input.context.Priority;
```

You need a Context that explains a bit your working environment, something like:

```java
Context context = new ContextBuilder()
    .priority(Priority.REALTIME)
    .build();
```

Then you need an executor and a mode:

```java
import com.optimaize.anythingworks.common.host.Host;
import com.optimaize.anythingworks.common.host.Protocol;
import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.lib.NameApiModeFactory;
import org.nameapi.client.lib.NameApiPortUrlFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;

CommandExecutor executor = NameApiRemoteExecutors.get();
Mode mode = NameApiModeFactory.withContext(
        "your-api-key",
        context,
        //the default and live server is "api.nameapi.org"
        new Host("api.nameapi.org", Protocol.HTTPS), NameApiPortUrlFactory.version5_3()
);
```

Now you're ready to execute commands.




## Send a ping

This code sends a simple ping to nameapi to test the connection:

```java
import org.nameapi.client.services.system.ping.PingCommand;

PingCommand command = new PingCommand();
executor.execute(command, mode, null).get(); //returns "pong"
```

## Input / Output

All input objects come with builders or nicely documented setters.
The result objects returned by the services all have fully documented getters.
Many input arguments are optional - that means you can start simple, and add more as you need.
The vocabulary for the communication, with input/output classes, is in the separate "Ontology" software. It is included as a Maven dependency. For the project page see https://github.com/optimaize/nameapi-ontology-java

Behind the scenes this service api uses REST (previous versions used SOAP). But luckily you don't need to worry about any
of the interface detail, you can just use the provided classes.

#### Person input object

Most services accept a 'Person' as input. This person contains a name, and optionally
more data such as gender, birth date etc.
The name can be just a single "full name" string, or it can be composed of multiple
fields like given name, middle name, surname.
This standardized api makes it simple to use different services in a consistent way,
and is very convenient in accepting the data however you have it at hands.

Creating a simple person looks something like this:

```java
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.name.InputPersonName;
import org.nameapi.ontology5.input.entities.person.name.builder.NameBuilders;

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
import org.nameapi.client.services.parser.personnameparser.PersonNameParserCommand;
import org.nameapi.ontology5.services.parser.personnameparser.PersonNameParserResult;

PersonNameParserCommand command = new PersonNameParserCommand();
PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
```


## Name Genderizer

Name genderizing is the process of identifying the gender based on a person's name.

Using the objects created earlier:

```java
import org.nameapi.client.services.genderizer.persongenderizer.PersonGenderizerCommand;
import org.nameapi.ontology5.services.genderizer.GenderizerResult;

PersonGenderizerCommand command = new PersonGenderizerCommand();
GenderizerResult result = executor.execute(command, mode, inputPerson).get();
```


## Name Matcher

The Name Matcher compares names and name pairs to discover whether the people could possibly be one and the same person.

This service takes 2 people as input:

```java
import org.nameapi.client.services.matcher.personmatcher.PersonMatcherArgument;
import org.nameapi.client.services.matcher.personmatcher.PersonMatcherCommand;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.services.matcher.personmatcher.PersonMatcherResult;

PersonMatcherCommand command = new PersonMatcherCommand();
NaturalInputPerson person1 = new NaturalInputPersonBuilder().name( NameBuilders.western().fullname("John F. Kennedy").build() ).build();
NaturalInputPerson person2 = new NaturalInputPersonBuilder().name( NameBuilders.western().fullname("Jack Kennedy").build() ).build();
PersonMatcherArgument argument = new PersonMatcherArgument(person1, person2);
PersonMatcherResult result = executor.execute(command, mode, argument).get();
```


## Name Formatter

The Name Formatter displays personal names in the desired form. This includes the order as well as upper and lower case writing.

```java
import org.nameapi.client.services.formatter.personnameformatter.PersonNameFormatterArgument;
import org.nameapi.client.services.formatter.personnameformatter.PersonNameFormatterCommand;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.services.formatter.FormatterProperties;
import org.nameapi.ontology5.services.formatter.FormatterResult;

PersonNameFormatterCommand command = new PersonNameFormatterCommand();
NaturalInputPerson person = new NaturalInputPersonBuilder().name( NameBuilders.western().fullname("john f. kennedy").build() ).build();
FormatterProperties properties = new FormatterProperties(true);
PersonNameFormatterArgument argument = new PersonNameFormatterArgument(person, properties);
FormatterResult formatterResult = executor.execute(command, mode, argument).get();
```

## Risk Detector

Detects various types of possibly fake data in person records.

```java
import org.nameapi.ontology5.input.entities.address.StructuredAddressBuilder;
import org.nameapi.ontology5.input.entities.address.StructuredPlaceInfoBuilder;
import org.nameapi.ontology5.input.entities.address.StructuredStreetInfoBuilder;
import org.nameapi.ontology5.input.entities.contact.EmailAddressFactory;
import org.nameapi.ontology5.input.entities.contact.TelNumberFactory;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.name.builder.WesternInputPersonNameBuilder;
import org.nameapi.ontology5.services.riskdetector.*;

PersonRiskDetectorCommand command = new PersonRiskDetectorCommand();
InputPerson person = new NaturalInputPersonBuilder()
        .name(new WesternInputPersonNameBuilder().givenName("John").surname("Doe").build())
        .addEmail(EmailAddressFactory.forAddress("john.doe@example.com"))
        .addTelNumber(TelNumberFactory.forNumber("999 999 999"))
        .addAddressForAll(
            new StructuredAddressBuilder()
                .placeInfo(new StructuredPlaceInfoBuilder().locality("Atlantis").postalCode("55555").build())
                .streetInfo(new StructuredStreetInfoBuilder().streetName("Hill road").houseNumber("72").build())
               .build())
        .build();
RiskDetectorResult result = executor.execute(command, mode, person).get();
```



## Email Name Parser

The Email Name Parser extracts names out of email addresses.

```java
import org.nameapi.client.services.email.emailnameparser.EmailNameParserCommand;
import org.nameapi.ontology5.services.email.emailnameparser.EmailNameParserResult;

EmailNameParserCommand command = new EmailNameParserCommand();
EmailNameParserResult result = executor.execute(command, mode, "john.doe@example.com").get();
```


## Disposable Email Address Detector

The DEA-Detector checks email addresses against a list of known "trash domains" such as mailinator.com.

```java
import org.nameapi.client.services.email.disposableemailaddressdetector.DisposableEmailAddressDetectorCommand;
import org.nameapi.ontology5.services.email.disposableemailaddressdetector.DisposableEmailAddressDetectorResult;

DisposableEmailAddressDetectorCommand command = new DisposableEmailAddressDetectorCommand();
DisposableEmailAddressDetectorResult result = executor.execute(command, mode, "blahblah@10minutemail.com").get();
```

