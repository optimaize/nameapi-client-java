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
 * @author Nicole Torres / emilia
 */
public class AE_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();



    @Test(dataProvider = "test_AE_1")
    public void test_AE_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals("حسّان", personName.getFirst(TermType.GIVENNAME).get().getString());
        assertEquals("عبد العزيز", personName.getSecond(TermType.GIVENNAME).get().getString());
        assertEquals("المصري", personName.getFirst(TermType.SURNAME).get().getString());
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }


    @DataProvider
    protected Object[][] test_AE_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("حسّان عبد العزيز المصري").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("حسّان عبد العزيز").surname("المصري").build()).build()}
        };
    }

    @Test(dataProvider = "test_AE_2")
    public void test_AE_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals("Hassan", personName.getFirst(TermType.GIVENNAME).get().getString());
        assertEquals("Abdul-Aziz", personName.getSecond(TermType.GIVENNAME).get().getString());
        assertEquals("Al-Masri", personName.getFirst(TermType.SURNAME).get().getString());
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }


    @DataProvider
    protected Object[][] test_AE_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Hassan Abdul-Aziz Al-Masri").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Hassan Abdul-Aziz").surname("Al-Masri").build()).build()}
        };
    }

    @Test(dataProvider = "test_AE_3")
    public void test_AE_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals("Hiba", personName.getFirst(TermType.GIVENNAME).get().getString());
        assertEquals("Al-Baghdadi", personName.getFirst(TermType.SURNAME).get().getString());
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }


    @DataProvider
    protected Object[][] test_AE_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Hiba Al-Baghdadi").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Hiba").surname("Al-Baghdadi").build()).build()}
        };
    }

    @Test(dataProvider = "test_AE_4")
    public void test_AE_4(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals("هبة", personName.getFirst(TermType.GIVENNAME).get().getString());
        assertEquals("لبغدادي", personName.getFirst(TermType.SURNAME).get().getString());
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }


    @DataProvider
    protected Object[][] test_AE_4() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("هبة لبغدادي").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("هبة").surname("لبغدادي").build()).build()}
        };
    }
}
