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
import org.nameapi.ontology5.output.entities.person.name.OutputPersonName;
import org.nameapi.ontology5.output.entities.person.name.TermType;
import org.nameapi.ontology5.services.parser.personnameparser.ParsedPerson;
import org.nameapi.ontology5.services.parser.personnameparser.PersonNameParserResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Nicole Torres
 */
public class US_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_US_1")
    public void test_US_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "John");
        assertEquals(personName.getFirst(TermType.GIVENNAMEINITIAL).get().getString(), "F.");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Kennedy");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_US_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("John F. Kennedy").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("John F.").surname("Kennedy").build()).build()},
        };
    }

    @Test(dataProvider = "test_US_2")
    public void test_US_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Jane");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Doe");
        assertEquals(personName.getFirst(TermType.NAMEATBIRTHINDICATOR).get().getString(), "nee");
        assertEquals(personName.getFirst(TermType.SURNAMEATBIRTH).get().getString(), "Johnson");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_US_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Jane Doe nee Johnson").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Jane").surname("Doe nee Johnson").build()).build()},
        };
    }

    @Test(dataProvider = "test_US_3")
    public void test_US_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "William");
        assertEquals(personName.getFirst(TermType.NICKNAME).get().getString(), "Bill");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Gates");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_US_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("William \"Bill\" Gates").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("William \"Bill\"").surname("Gates").build()).build()},
        };
    }

    @Test(dataProvider = "test_US_4")
    public void test_US_4(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();

        /* when there are MULTIPLE people the service returns a list of ParsedPerson */
        ParsedPerson firstPerson = parsedPerson.getPeople().get(0);
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "John");
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Miller");
        assertEquals(firstPerson.getGender().getGender(), ComputedPersonGender.MALE);

        ParsedPerson secondPerson = parsedPerson.getPeople().get(1);
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Richard");
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Stone");
        assertEquals(secondPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_US_4() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("John Miller & Richard Stone").build()).build()},
        };
    }

    @Test(dataProvider = "test_US_5")
    public void test_US_5(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "William");
        assertEquals(personName.getSecond(TermType.GIVENNAME).get().getString(), "Henry");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Gates");
        assertEquals(personName.getFirst(TermType.QUALIFIER).get().getString(), "iii");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_US_5() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("William Henry Gates III").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("William Henry").surname("Gates III").build()).build()},
        };
    }

    @Test(dataProvider = "test_US_6")
    public void test_US_6(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Jennifer");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Thompson");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_US_6() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Jennifer Thompson").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Jennifer").surname("Thompson").build()).build()},
        };
    }
}
