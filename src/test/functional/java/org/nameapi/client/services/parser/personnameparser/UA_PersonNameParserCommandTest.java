package org.nameapi.client.services.parser.personnameparser;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.gender.ComputedPersonGender;
import org.nameapi.ontology5.input.entities.person.name.builder.AmericanInputPersonNameBuilder;
import org.nameapi.ontology5.input.entities.person.name.builder.WesternInputPersonNameBuilder;
import org.nameapi.ontology5.output.entities.person.name.OutputPersonName;
import org.nameapi.ontology5.output.entities.person.name.TermType;
import org.nameapi.ontology5.services.parser.personnameparser.ParsedPerson;
import org.nameapi.ontology5.services.parser.personnameparser.PersonNameParserResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Nicole Torres / emilia
 */
public class UA_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_UA_1")
    public void test_UA_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Dmytro");
        assertEquals(personName.getFirst(TermType.MIDDLENAME).get().getString(), "Ivanovic");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Pavlenko");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_UA_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Dmytro Ivanovic Pavlenko").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Dmytro").middleName("Ivanovic").surname("Pavlenko").build()).build()},
        };
    }

    @Test(dataProvider = "test_UA_2")
    public void test_UA_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        //the second match is the one with MIDDLE NAME term type extracted
        ParsedPerson parsedPerson = result.getMatches().get(1).getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Andriy");
        assertEquals(personName.getFirst(TermType.MIDDLENAME).get().getString(), "Mykolayovych");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Shevchenko");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_UA_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Andriy Mykolayovych Shevchenko").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Andriy").middleName("Mykolayovych").surname("Shevchenko").build()).build()},
        };
    }

    @Test(dataProvider = "test_UA_3")
    public void test_UA_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getMatches().get(0).getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Андрій");
        assertEquals(personName.getFirst(TermType.MIDDLENAME).get().getString(), "Миколайович");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Шевченко");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_UA_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Андрій Миколайович Шевченко").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Андрій").middleName("Миколайович").surname("Шевченко").build()).build()},
        };
    }

    @Test(dataProvider = "test_UA_4")
    public void test_UA_4(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getMatches().get(0).getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Dariya");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Zgoba");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_UA_4() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Dariya Zgoba").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Dariya").surname("Zgoba").build()).build()},
        };
    }

    @Test(dataProvider = "test_UA_5")
    public void test_UA_5(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getMatches().get(0).getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Дарина");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Згоба");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_UA_5() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Дарина Згоба").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Дарина").surname("Згоба").build()).build()},
        };
    }

}
