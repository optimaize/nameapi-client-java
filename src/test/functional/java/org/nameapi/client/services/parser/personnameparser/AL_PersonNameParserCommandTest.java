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
public class AL_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_AL_1")
    public void test_AL_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Altin");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Hoxha");
    }
    @DataProvider
    protected Object[][] test_AL_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Altin Hoxha").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Altin").surname("Hoxha").build()).build()}
        };
    }

    @Test(dataProvider = "test_AL_2")
    public void test_AL_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        assertEquals(parsedPerson.getPersonType(), PersonType.MULTIPLE);

        /* when there are MULTIPLE people the service returns a list of ParsedPerson */
        ParsedPerson firstPerson = parsedPerson.getPeople().get(0);
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Altin");
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Hoxha");
        assertEquals(firstPerson.getGender().getGender(), ComputedPersonGender.MALE);

        ParsedPerson secondPerson = parsedPerson.getPeople().get(1);
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Sidorela");
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Hoxha");
        assertEquals(secondPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_AL_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Altin dhe Sidorela Hoxha").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Altin dhe Sidorela").surname("Hoxha").build()).build()}
        };
    }

    @Test(dataProvider = "test_AL_3")
    public void test_AL_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Amelija");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Bektashi");
    }
    @DataProvider
    protected Object[][] test_AL_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Amelija Bektashi").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Amelija").surname("Bektashi").build()).build()}
        };
    }

}
