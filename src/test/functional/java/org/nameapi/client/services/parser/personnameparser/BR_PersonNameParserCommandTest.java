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
public class BR_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_BR_1")
    public void test_BR_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Manuel");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Tavares");
        assertEquals(personName.getSecond(TermType.SURNAME).get().getString(), "Fernandes");
        assertEquals(personName.getFirst(TermType.QUALIFIER).get().getString(), "Filho");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_BR_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Manuel Tavares Fernandes Filho").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Manuel").surname("Tavares Fernandes Filho").build()).build()}
        };
    }


    @Test(dataProvider = "test_BR_2")
    public void test_BR_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Maria");
        assertEquals(personName.getSecond(TermType.GIVENNAME).get().getString(), "Eduarda");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "da Silva");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_BR_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Maria Eduarda da Silva").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Maria Eduarda").surname("da Silva").build()).build()}
        };
    }
}
