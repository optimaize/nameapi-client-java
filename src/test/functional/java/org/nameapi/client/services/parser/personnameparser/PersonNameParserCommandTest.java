package org.nameapi.client.services.parser.personnameparser;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.ontology5.input.entities.person.LegalInputPerson;
import org.nameapi.ontology5.input.entities.person.LegalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.gender.ComputedPersonGender;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;
import org.nameapi.ontology5.input.entities.person.name.builder.AmericanInputPersonNameBuilder;
import org.nameapi.ontology5.input.entities.person.name.builder.NameBuilders;
import org.nameapi.ontology5.input.entities.person.name.builder.WesternInputPersonNameBuilder;
import org.nameapi.ontology5.output.entities.person.name.OutputPersonName;
import org.nameapi.ontology5.output.entities.person.name.TermType;
import org.nameapi.ontology5.services.parser.personnameparser.DisputeType;
import org.nameapi.ontology5.services.parser.personnameparser.ParsedPerson;
import org.nameapi.ontology5.services.parser.personnameparser.ParsedPersonMatch;
import org.nameapi.ontology5.services.parser.personnameparser.PersonNameParserResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class PersonNameParserCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "testNaturalPerson_1")
    public void testNaturalPerson_1(NaturalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName firstName = parsedPerson.getOutputPersonName();
        assertEquals("Petra", firstName.getFirst(TermType.GIVENNAME).get().getString());
        assertEquals("Müller", firstName.getFirst(TermType.SURNAME).get().getString());
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
    }
    @DataProvider
    protected Object[][] testNaturalPerson_1() {
        return new Object[][]{
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("Petra Müller").build()).build()},
                {new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().givenName("Petra").surname("Müller").build()).build()}
        };
    }

    @Test
    public void testAmericanStyle_1() throws Exception {
        NaturalInputPerson inputPerson = new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder()
                .prefix("Dr.")
                .givenName("Peter")
                .middleName("T.")
                .surname("Johnson")
                .suffix("jr")
                .build()).build();
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName firstName = parsedPerson.getOutputPersonName();
        assertEquals("Dr.", firstName.getFirst(TermType.TITLE).get().getString());
        assertEquals("Peter", firstName.getFirst(TermType.GIVENNAME).get().getString());
        assertEquals("T.", firstName.getFirst(TermType.MIDDLENAME).get().getString()); //TODO will be MIDDLENAMEINITIAL
        assertEquals("Johnson", firstName.getFirst(TermType.SURNAME).get().getString());
        assertEquals("jr", firstName.getFirst(TermType.QUALIFIER).get().getString());
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }
    @Test
    public void testAmericanStyle_2() throws Exception {
        NaturalInputPerson inputPerson = new NaturalInputPersonBuilder().name(new AmericanInputPersonNameBuilder()
                .fullname("Dr. Peter T. Johnson jr")
                .build()).build();
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName firstName = parsedPerson.getOutputPersonName();
        assertEquals("Dr.", firstName.getFirst(TermType.TITLE).get().getString());
        assertEquals("Peter", firstName.getFirst(TermType.GIVENNAME).get().getString());
        //assertEquals("T.", firstName.getFirst(TermType.MIDDLENAME).get().getString()); //currenty GIVENNAMEINITIAL because the client has to send a flag saying he prefers American style names. TODO will be MIDDLENAMEINITIAL
        assertEquals("Johnson", firstName.getFirst(TermType.SURNAME).get().getString());
        assertEquals("jr", firstName.getFirst(TermType.QUALIFIER).get().getString());
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }


    @Test(dataProvider = "testLegalPerson_1")
    public void testLegalPerson_1(LegalInputPerson inputPerson) throws Exception {
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName firstName = parsedPerson.getOutputPersonName();
        assertEquals("Google", firstName.getFirst(TermType.BUSINESSNAME).get().getString());
        assertEquals("Inc.", firstName.getFirst(TermType.BUSINESSLEGALFORM).get().getString());
    }
    @DataProvider
    protected Object[][] testLegalPerson_1() {
        return new Object[][]{
                {new LegalInputPersonBuilder().name(NameBuilders.legal().name("Google Inc.").build()).build()},
                {new LegalInputPersonBuilder().name(NameBuilders.legal().name("Google").legalForm("Inc.").build()).build()}
        };
    }


    @Test
    public void genderDispute() throws Exception {
        NaturalInputPerson inputPerson = new NaturalInputPersonBuilder()
                .name(new WesternInputPersonNameBuilder().fullname("Petra Müller").build())
                .gender(StoragePersonGender.MALE)
                .build();
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPersonMatch bestMatch = result.getBestMatch();

        ParsedPerson parsedPerson = bestMatch.getParsedPerson();
        OutputPersonName firstName = parsedPerson.getOutputPersonName();
        assertEquals("Petra", firstName.getFirst(TermType.GIVENNAME).get().getString());
        assertEquals("Müller", firstName.getFirst(TermType.SURNAME).get().getString());

        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.FEMALE);
        assertEquals(bestMatch.getParserDisputes().size(), 1);
        assertEquals(bestMatch.getParserDisputes().get(0).getDisputeType(), DisputeType.GENDER);
    }



    @Test
    public void testParseSingleGivenName() throws Exception {
        NaturalInputPerson inputPerson = new NaturalInputPersonBuilder().name(new WesternInputPersonNameBuilder().fullname("John").build()).build();
        PersonNameParserCommand command = new PersonNameParserCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        PersonNameParserResult result = executor.execute(command, mode, inputPerson).get();
        ParsedPerson parsedPerson = result.getBestMatch().getParsedPerson();
        OutputPersonName firstName = parsedPerson.getOutputPersonName();
        assertEquals("John", firstName.getFirst(TermType.GIVENNAME).get().getString());
        assertEquals(parsedPerson.getGender().getGender(), ComputedPersonGender.MALE);
    }

}
