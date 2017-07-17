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
 * @author Nicole Torres / emilia
 */
public class IS_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_IS_1")
    public void test_IS_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Freyja");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Jónsdóttir");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_IS_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Freyja Jónsdóttir").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Freyja").surname("Jónsdóttir").build()).build()}
        };
    }

    @Test(dataProvider = "test_IS_2")
    public void test_IS_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.SALUTATION).get().getString(), "Frú");
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Guðrún");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Blöndal");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_IS_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Frú Guðrún Blöndal").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Frú Guðrún").surname("Blöndal").build()).build()}
        };
    }
    @Test(dataProvider = "test_IS_3")
    public void test_IS_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        assertEquals(parsedPerson.getPersonType(), PersonType.MULTIPLE);

        /* when there are MULTIPLE people the service returns a list of ParsedPerson */
        ParsedPerson firstPerson = parsedPerson.getPeople().get(0);
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Freyja");
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Jónsdóttir");
        assertEquals(firstPerson.getGender().getGender(), ComputedPersonGender.FEMALE);

        ParsedPerson secondPerson = parsedPerson.getPeople().get(1);
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Guðmundur");
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Jónsson");
        assertEquals(secondPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_IS_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Freyja Jónsdóttir og Guðmundur Jónsson").build()).build()},
        };
    }

    @Test(dataProvider = "test_IS_4")
    public void test_IS_4(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Guðmundur");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Kristjánsson");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_IS_4() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Guðmundur Kristjánsson").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Guðmundur").surname("Kristjánsson").build()).build()}
        };
    }
}
