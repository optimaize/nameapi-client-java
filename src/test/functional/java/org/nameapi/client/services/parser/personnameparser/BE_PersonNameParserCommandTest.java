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
public class BE_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_BE_1")
    public void test_BE_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Gaston");
        assertEquals(personName.getSecond(TermType.GIVENNAME).get().getString(), "Cyriel");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Durnez");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_BE_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Gaston Cyriel Durnez").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Gaston Cyriel").surname("Durnez").build()).build()}
        };
    }

    @Test(dataProvider = "test_BE_2")
    public void test_BE_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Jan");
        assertEquals(personName.getSecond(TermType.GIVENNAME).get().getString(), "Theodoor");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "van Rijswijck");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_BE_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Jan Theodoor van Rijswijck").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Jan Theodoor").surname("van Rijswijck").build()).build()}
        };
    }

    @Test(dataProvider = "test_BE_3")
    public void test_BE_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "François");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Weyergans");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_BE_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("François Weyergans").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("François").surname("Weyergans").build()).build()}
        };
    }

}
