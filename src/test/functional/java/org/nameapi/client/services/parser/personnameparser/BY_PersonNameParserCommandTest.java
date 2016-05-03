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
 * @author Nicole Torres
 */
public class BY_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_BY_1")
    public void test_BY_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Nikita");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Ivanoŭ");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.NEUTRAL);
    }
    @DataProvider
    protected Object[][] test_BY_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Nikita Ivanoŭ").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Nikita").surname("Ivanoŭ").build()).build()}
        };
    }

    @Test(dataProvider = "test_BY_2")
    public void test_BY_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Dmitry");
        assertEquals(personName.getFirst(TermType.MIDDLENAME).get().getString(), "Aleksandrovich");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Koldun");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_BY_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Dmitry Aleksandrovich Koldun").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Dmitry").middleName("Aleksandrovich").surname("Koldun").build()).build()}
        };
    }

}
