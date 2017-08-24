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
public class KZ_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_KZ_1")
    public void test_KZ_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Yerasyl");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Kaliev");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_KZ_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Yerasyl Kaliev").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Yerasyl").surname("Kaliev").build()).build()}
        };
    }

    @Test(dataProvider = "test_KZ_2")
    public void test_KZ_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Ерасыл");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Калиев");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_KZ_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Ерасыл Калиев").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Ерасыл").surname("Калиев").build()).build()}
        };
    }

    @Test(dataProvider = "test_KZ_3")
    public void test_KZ_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Yerasyl");
        assertEquals(personName.getFirst(TermType.MIDDLENAME).get().getString(), "Nurtayevich");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Kaliev");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_KZ_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Yerasyl").middleName("Nurtayevich").surname("Kaliev").build()).build()}
        };
    }

    @Test(dataProvider = "test_KZ_4")
    public void test_KZ_4(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Ерасыл");
        assertEquals(personName.getFirst(TermType.MIDDLENAME).get().getString(), "Нуртаевич");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Калиев");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_KZ_4() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Ерасыл").middleName("Нуртаевич").surname("Калиев").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Ерасыл Нуртаевич Калиев").build()).build()},
        };
    }

    @Test(dataProvider = "test_KZ_5")
    public void test_KZ_5(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Aruzhan");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Aitkhozhina");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_KZ_5() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Aruzhan").surname("Aitkhozhina").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Aruzhan Aitkhozhina").build()).build()},
        };
    }
}
