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
public class GR_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_GR_1")
    public void test_GR_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Στυλιανος");
        assertEquals(personName.getSecond(TermType.GIVENNAME).get().getString(), "Αλέξανδρος");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Παπαδόπουλος");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_GR_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Στυλιανος Αλέξανδρος Παπαδόπουλος").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Στυλιανος Αλέξανδρος").surname("Παπαδόπουλος").build()).build()}
        };
    }

    @Test(dataProvider = "test_GR_2")
    public void test_GR_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Stylianos");
        assertEquals(personName.getSecond(TermType.GIVENNAME).get().getString(), "Alexandros");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Papadopoulos");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_GR_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Stylianos Alexandros Papadopoulos").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Stylianos Alexandros").surname("Papadopoulos").build()).build()}
        };
    }
    @Test(dataProvider = "test_GR_3")
    public void test_GR_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        assertEquals(parsedPerson.getPersonType(), PersonType.MULTIPLE);

        /* when there are MULTIPLE people the service returns a list of ParsedPerson */
        ParsedPerson firstPerson = parsedPerson.getPeople().get(0);
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Γεώργιος");
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Βλάχος");
        assertEquals(firstPerson.getGender().getGender(), ComputedPersonGender.MALE);

        ParsedPerson secondPerson = parsedPerson.getPeople().get(1);
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Στυλιανος");
        assertEquals(secondPerson.getOutputPersonName().getSecond(TermType.GIVENNAME).get().getString(), "Αλέξανδρος");
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Παπαδόπουλος");
        assertEquals(secondPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_GR_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Γεώργιος Βλάχος και Στυλιανος Αλέξανδρος Παπαδόπουλος").build()).build()},
        };
    }

    @Test(dataProvider = "test_GR_4")
    public void test_GR_4(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        assertEquals(parsedPerson.getPersonType(), PersonType.MULTIPLE);

        /* when there are MULTIPLE people the service returns a list of ParsedPerson */
        ParsedPerson firstPerson = parsedPerson.getPeople().get(0);
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Georgios");
        assertEquals(firstPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Vlahos");
        assertEquals(firstPerson.getGender().getGender(), ComputedPersonGender.MALE);

        ParsedPerson secondPerson = parsedPerson.getPeople().get(1);
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.GIVENNAME).get().getString(), "Stylianos");
        assertEquals(secondPerson.getOutputPersonName().getSecond(TermType.GIVENNAME).get().getString(), "Alexandros");
        assertEquals(secondPerson.getOutputPersonName().getFirst(TermType.SURNAME).get().getString(), "Papadopoulos");
        assertEquals(secondPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_GR_4() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Georgios Vlahos kai Stylianos Alexandros Papadopoulos").build()).build()},
        };
    }

    @Test(dataProvider = "test_GR_5")
    public void test_GR_5(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Angeliki");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Papadaki");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_GR_5() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Angeliki Papadaki").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Angeliki").surname("Papadaki").build()).build()}
        };
    }

    @Test(dataProvider = "test_GR_6")
    public void test_GR_6(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Αγγελική");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Παπαδάκη");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_GR_6() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Αγγελική Παπαδάκη").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Αγγελική").surname("Παπαδάκη").build()).build()}
        };
    }
}
