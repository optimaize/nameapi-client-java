package org.nameapi.client.services.parser.personnameparser;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.gender.ComputedPersonGender;
import org.nameapi.ontology5.input.entities.person.name.builder.WesternInputPersonNameBuilder;
import org.nameapi.ontology5.output.entities.person.PersonType;
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
public class AM_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_AM_1")
    public void test_AM_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Anahit");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Hovhannisyan");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_AM_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Anahit Hovhannisyan").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Anahit").surname("Hovhannisyan").build()).build()}
        };
    }

    @Test(dataProvider = "test_AM_2")
    public void test_AM_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        assertEquals(parsedPerson.getPersonType(), PersonType.MULTIPLE);

        /* when there are MULTIPLE people the service returns a list of ParsedPerson */
        ParsedPerson firstPerson = parsedPerson.getPeople().get(0);
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Anahit");
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Hovhannisyan");
        assertEquals(firstPerson.getGender().getGender(), ComputedPersonGender.FEMALE);

        ParsedPerson secondPerson = parsedPerson.getPeople().get(1);
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Narek");
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Hovhannisyan");
        assertEquals(secondPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_AM_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Anahit isk Narek Hovhannisyan").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Anahit isk Narek").surname("Hovhannisyan").build()).build()}
        };
    }

    @Test(dataProvider = "test_AM_3")
    public void test_AM_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Անահիտ");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Հովհաննիսյան");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_AM_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Անահիտ Հովհաննիսյան").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Անահիտ").surname("Հովհաննիսյան").build()).build()}
        };
    }

    @Test(dataProvider = "test_AM_4")
    public void test_AM_4(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        assertEquals(parsedPerson.getPersonType(), PersonType.MULTIPLE);

        /* when there are MULTIPLE people the service returns a list of ParsedPerson */
        ParsedPerson firstPerson = parsedPerson.getPeople().get(0);
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Անահիտ");
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Հովհաննիսյան");
        assertEquals(firstPerson.getGender().getGender(), ComputedPersonGender.FEMALE);

        ParsedPerson secondPerson = parsedPerson.getPeople().get(1);
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Նարեկ");
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Հովհաննիսյան");
        assertEquals(secondPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_AM_4() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Անահիտ իսկ Նարեկ Հովհաննիսյան").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Անահիտ իսկ Նարեկ").surname("Հովհաննիսյան").build()).build()}
        };
    }

}
