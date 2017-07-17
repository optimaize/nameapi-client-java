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
 * @author Nicole Torres / emilia
 */
public class RU_PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "test_RU_1")
    public void test_RU_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Lev");
        assertEquals(personName.getFirst(TermType.MIDDLENAME).get().getString(), "Nikolayevich");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Tolstoy");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_RU_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Lev Nikolayevich Tolstoy").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Lev").middleName("Nikolayevich").surname("Tolstoy").build()).build()},
        };
    }

    @Test(dataProvider = "test_RU_2")
    public void test_RU_2(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Лев");
        assertEquals(personName.getFirst(TermType.MIDDLENAME).get().getString(), "Николаевич");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Толстой");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @DataProvider
    protected Object[][] test_RU_2() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Лев Николаевич Толстой").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Лев").middleName("Николаевич").surname("Толстой").build()).build()},
        };
    }

    @Test(dataProvider = "test_RU_3")
    public void test_RU_3(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName personName = parsedPerson.getOutputPersonName();
        assertEquals(personName.getFirst(TermType.GIVENNAME).get().getString(), "Елизавета");
        assertEquals(personName.getFirst(TermType.MIDDLENAME).get().getString(), "Андреевна");
        assertEquals(personName.getFirst(TermType.SURNAME).get().getString(), "Соловьёва");
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] test_RU_3() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().fullname("Елизавета Андреевна Соловьёва").build()).build()},
                {new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder().givenName("Елизавета").middleName("Андреевна").surname("Соловьёва").build()).build()},
        };
    }

}
