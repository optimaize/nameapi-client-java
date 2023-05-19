package org.nameapi.client.services.riskdetector.person;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.ontology5.input.entities.address.StructuredAddressBuilder;
import org.nameapi.ontology5.input.entities.address.StructuredPlaceInfoBuilder;
import org.nameapi.ontology5.input.entities.address.StructuredStreetInfoBuilder;
import org.nameapi.ontology5.input.entities.contact.EmailAddressFactory;
import org.nameapi.ontology5.input.entities.contact.TelNumberFactory;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.age.AgeInfo;
import org.nameapi.ontology5.input.entities.person.age.AgeInfoFactory;
import org.nameapi.ontology5.services.riskdetector.*;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class PersonRiskDetectorCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider = "fullname_risk")
    public void fullname_risk(String fullname, DataItem dataItem, RiskType riskType) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName(fullname))
                .build();
        RiskDetectorResult result = run(person);
        DetectedRisk mostRisky = result.getWorstRisk().get();
        assertEquals(mostRisky.getDataItem(), dataItem);
        assertEquals(mostRisky.getRiskType(), riskType);
    }
    @DataProvider
    protected Object[][] fullname_risk() {
        return new Object[][]{
                {"John Doe", DataItem.NAME, FakeRiskType.PLACEHOLDER},
                {"Barak Obama", DataItem.NAME, FakeRiskType.FAMOUS},
                {"Mickey Mouse", DataItem.NAME, FakeRiskType.FICTIONAL},
                {"Asdf asdf", DataItem.NAME, FakeRiskType.RANDOM_TYPING},
                {"Sandy Beach", DataItem.NAME, FakeRiskType.HUMOROUS},
//                {"Віталій Кличко", DataItem.NAME, FakeRiskType.FAMOUS},
                {"Asdfdsadsdasdasvvvvfvasdf", DataItem.NAME, FakeRiskType.RANDOM_TYPING},

                {"None of your business", DataItem.NAME, FakeRiskType.PLACEHOLDER},
                {"Stupid Cow", DataItem.NAME, FakeRiskType.INVALID},
                {"Me myself and I", DataItem.NAME, FakeRiskType.INVALID},

                // if name is parsed separately we get expected disguised type
//                {"xxxPeter Meyerxxx", DataItem.NAME, FakeRiskType.RANDOM_TYPING},
                {"P e t e r M e y e r", DataItem.NAME, FakeRiskType.INVALID},
        };
    }

    @Test(dataProvider = "namesAsGnSn_risk")
    public void namesAsGnSn_risk(String gn, String sn, DataItem dataItem, RiskType riskType) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName(gn, sn))
                .build();
        RiskDetectorResult result = run(person);
        DetectedRisk mostRisky = result.getWorstRisk().get();
        assertEquals(mostRisky.getDataItem(), dataItem);
        assertEquals(mostRisky.getRiskType(), riskType);
    }
    @DataProvider
    protected Object[][] namesAsGnSn_risk() {
        return new Object[][]{
                {"John", "Doe", DataItem.NAME, FakeRiskType.PLACEHOLDER},
                {"Barak", "Obama", DataItem.NAME, FakeRiskType.FAMOUS},
                {"Mickey", "Mouse", DataItem.NAME, FakeRiskType.FICTIONAL},
                {"Asdf", "asdf", DataItem.NAME, FakeRiskType.RANDOM_TYPING},
                {"Sandy", "Beach", DataItem.NAME, FakeRiskType.HUMOROUS},
//                {"Віталій", "Кличко", DataItem.NAME, FakeRiskType.FAMOUS},
                {"Asdfdsadsd", "asdasvvvvfvasdf", DataItem.NAME, FakeRiskType.RANDOM_TYPING},

                {"Stupid", "Cow", DataItem.NAME, FakeRiskType.INVALID},

                // server knows it is 'DisguiseRiskType.OTHER', but this information is erased by serializer
                {"xxxPeter", "Meyerxxx", DataItem.NAME, FakeRiskType.OTHER},

                // get 2 risks with equal score=1: invalid(too many extra char.) and disguised(spaced typing)
                {"P e t e r", "M e y e r", DataItem.NAME, FakeRiskType.INVALID},

                // server knows it is 'DisguiseRiskType.OTHER', but this information is erased by serializer
                {"Petttter", "Meyyyyer", DataItem.NAME, FakeRiskType.OTHER},

                {"Firstname", "Lastname", DataItem.NAME, FakeRiskType.INVALID},
        };
    }

    @Test(dataProvider = "fullnames_ok")
    public void fullnames_ok(String fullName) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName(fullName))
                .build();
        RiskDetectorResult result = run(person);
        AssertJUnit.assertFalse(result.hasRisk());
    }
    @DataProvider
    protected Object[][] fullnames_ok() {
        return new Object[][] {
                {"Shayla Raven"},
                {"Lynette Osman"},
                {"Avril Myles"},
                {"Susana Braunsteinf"},
                {"Jennine Manuelito"},
                {"Alexa Ricotta"},
                {"Jinny Shealey"},
                {"Maragaret Drew"},
                {"Андрій Петренко"},
        };
    }

    @Test(dataProvider = "placeNames_risk")
    public void placeNames_risk(String placeName, DataItem dataItem, RiskType riskType) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .addAddressForAll(
                        new StructuredAddressBuilder().placeInfo(
                                new StructuredPlaceInfoBuilder().locality(placeName).build()
                        ).build()
                )
                .build();

        RiskDetectorResult result = run(person);
        DetectedRisk mostRisky = result.getWorstRisk().get();
        assertEquals(mostRisky.getDataItem(), dataItem);
        assertEquals(mostRisky.getRiskType(), riskType);
    }
    @DataProvider
    protected Object[][] placeNames_risk() {
        return new Object[][] {
                {"dsadasdsadqwdqw", DataItem.ADDRESS, FakeRiskType.RANDOM_TYPING},
                {"xxxmunichxxx", DataItem.ADDRESS, DisguiseRiskType.PADDING},
                {"Z u r i c h", DataItem.ADDRESS, DisguiseRiskType.SPACED_TYPING},
                {"Zurrrrich", DataItem.ADDRESS, DisguiseRiskType.STUTTER_TYPING},
                {"урюпинск", DataItem.ADDRESS, FakeRiskType.PLACEHOLDER},
                {"Урюпинск", DataItem.ADDRESS, FakeRiskType.PLACEHOLDER},
                {"Мухосранск", DataItem.ADDRESS, FakeRiskType.PLACEHOLDER},
                {"бобруйск", DataItem.ADDRESS, FakeRiskType.PLACEHOLDER},
                {"black stump", DataItem.ADDRESS, FakeRiskType.HUMOROUS},
                {"Mortshire", DataItem.ADDRESS, FakeRiskType.FICTIONAL},
                {"Jerkwater", DataItem.ADDRESS, FakeRiskType.INVALID},
                {"Hollywood", DataItem.ADDRESS, FakeRiskType.FAMOUS},
        };
    }

    @Test(dataProvider = "placeNames_ok")
    public void placeNames_ok(String placeName) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .addAddressForAll(
                        new StructuredAddressBuilder().placeInfo(
                                new StructuredPlaceInfoBuilder().locality(placeName).build()
                        ).build()
                )
                .build();

        RiskDetectorResult result = run(person);
        AssertJUnit.assertFalse(result.hasRisk());
    }
    @DataProvider
    protected Object[][] placeNames_ok() {
        return new Object[][] {
                {"Bangkok"},
                {"Nairobi"},
                {"Beijing"},
                {"yokohama"},
                {"Lima"},
                {"Addis Ababa"},
                {"Берлин"},
                {"Київ"},
        };
    }

    @Test(dataProvider = "streetNames_risk")
    public void streetNames_risk(String streetName, DataItem dataItem, RiskType riskType) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .addAddressForAll(
                        new StructuredAddressBuilder().streetInfo(
                                new StructuredStreetInfoBuilder().streetName(streetName).build()
                        ).build()
                )
                .build();

        RiskDetectorResult result = run(person);
        DetectedRisk mostRisky = result.getWorstRisk().get();
        assertEquals(mostRisky.getDataItem(), dataItem);
        assertEquals(mostRisky.getRiskType(), riskType);
    }
    @DataProvider
    protected Object[][] streetNames_risk() {
        return new Object[][] {
                {"dsadasdsadqwdqw", DataItem.ADDRESS, FakeRiskType.RANDOM_TYPING},
                {"xxxfriedrichstrassexxx", DataItem.ADDRESS, DisguiseRiskType.PADDING},
                {"F r i e d r i c h s t r a s s e", DataItem.ADDRESS, DisguiseRiskType.SPACED_TYPING},
                {"Friedrrrrrichstrasse", DataItem.ADDRESS, DisguiseRiskType.STUTTER_TYPING},
        };
    }

    @Test(dataProvider = "streetNames_ok")
    public void streetNames_ok(String streetName) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .addAddressForAll(
                        new StructuredAddressBuilder().streetInfo(
                                new StructuredStreetInfoBuilder().streetName(streetName).build()
                        ).build()
                )
                .build();

        RiskDetectorResult result = run(person);
        AssertJUnit.assertFalse(result.hasRisk());
    }
    @DataProvider
    protected Object[][] streetNames_ok() {
        return new Object[][] {
                {"Dorfstr."},
                {"Hauptstr"},
                {"Motzstraße"},
                {"Gollanczstraße"},
                {"Invalidenstraße"},
                {"Siegesallee"},
        };
    }

    @Test(dataProvider = "emailAddresses_risk")
    public void emailAddresses_risk(String emailAddr, DataItem dataItem, RiskType riskType) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .addEmail(EmailAddressFactory.forAddress(emailAddr))
                .build();

        RiskDetectorResult result = run(person);
        DetectedRisk mostRisky = result.getWorstRisk().get();
        assertEquals(mostRisky.getDataItem(), dataItem);
        assertEquals(mostRisky.getRiskType(), riskType);
    }
    @DataProvider
    protected Object[][] emailAddresses_risk() {
        return new Object[][] {
                {"dqwdqw@dsds.sddsa", DataItem.EMAIL, FakeRiskType.RANDOM_TYPING},
                {"bill@microsoft.com", DataItem.EMAIL, FakeRiskType.PLACEHOLDER},
                {"bill@microsoft.de", DataItem.EMAIL, FakeRiskType.PLACEHOLDER},
                {"asdf@asdf.de", DataItem.EMAIL, FakeRiskType.OTHER},
                {"user@domain.com", DataItem.EMAIL, FakeRiskType.OTHER},
                {"nobody@nowhere.ua", DataItem.EMAIL, FakeRiskType.OTHER},
                // disposable
                {"DaDiDoo@mailinator.com", DataItem.EMAIL, FakeRiskType.OTHER}
        };
    }

    @Test(dataProvider = "emailAddresses_ok")
    public void emailAddresses_ok(String emailAddr) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .addEmail(EmailAddressFactory.forAddress(emailAddr))
                .build();

        RiskDetectorResult result = run(person);
        AssertJUnit.assertFalse(result.hasRisk());
    }
    @DataProvider
    protected Object[][] emailAddresses_ok() {
        return new Object[][] {
                {"andrei.petrenko@gmail.com"},
                {"ivan.petrenko@yahoo.com"},
                {"denis.ivanov68@yahoo.com"},
                {"denisivanov68@yahoo.com"},
                {"denisivanov68@yahoo.com"},
        };
    }

    @Test(dataProvider = "tel_risk")
    public void tel_risk(String telNumber, DataItem dataItem, RiskType riskType) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .addTelNumber(TelNumberFactory.forNumber(telNumber))
                .build();

        RiskDetectorResult result = run(person);
        DetectedRisk mostRisky = result.getWorstRisk().get();
        assertEquals(mostRisky.getDataItem(), dataItem);
        assertEquals(mostRisky.getRiskType(), riskType);
    }
    @DataProvider
    protected Object[][] tel_risk() {
        return new Object[][] {
                {"1151351516516516516516516515", DataItem.TEL, FakeRiskType.OTHER},
                {"11111111111111", DataItem.TEL, FakeRiskType.OTHER},
                {"123123123123123", DataItem.TEL, FakeRiskType.OTHER},
        };
    }

    @Test(dataProvider = "tel_ok")
    public void tel_ok(String telNumber) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .addTelNumber(TelNumberFactory.forNumber(telNumber))
                .build();

        RiskDetectorResult result = run(person);
        assertFalse(result.hasRisk());
    }
    @DataProvider
    protected Object[][] tel_ok() {
        return new Object[][] {
                {"+41 52 208 97 77"},
                {"+41 58 280 66 11"},
                {"+41 800 809 809"},
        };
    }

    @Test(dataProvider = "birthDates_risk")
    public void birthDates_risk(AgeInfo birthDate, DataItem dataItem, RiskType riskType) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .age(birthDate)
                .build();

        RiskDetectorResult result = run(person);
        DetectedRisk mostRisky = result.getWorstRisk().get();
        assertEquals(mostRisky.getDataItem(), dataItem);
        assertEquals(mostRisky.getRiskType(), riskType);
    }
    @DataProvider
    protected Object[][] birthDates_risk() {
        return new Object[][] {
                {AgeInfoFactory.forDate(1861, 3, 3), DataItem.AGE, FakeRiskType.OTHER},
                {AgeInfoFactory.forDate(2010, 3, 15), DataItem.AGE, FakeRiskType.OTHER},
                {AgeInfoFactory.forDate(1933, 3, 3), DataItem.AGE, FakeRiskType.OTHER},
        };
    }

    @Test(dataProvider = "birthDates_ok")
    public void birthDates_ok(AgeInfo birthDate) throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("Peter Meyer"))
                .age(birthDate)
                .build();

        RiskDetectorResult result = run(person);
        AssertJUnit.assertFalse(result.hasRisk());
    }
    @DataProvider
    protected Object[][] birthDates_ok() {
        return new Object[][] {
                {AgeInfoFactory.forDate(1961, 1, 2)},
                {AgeInfoFactory.forDate(1981, 1, 2)},
                {AgeInfoFactory.forDate(1995, 12, 31)},
        };
    }

    @Test
    public void multipleResults() throws Exception {
        InputPerson person = new NaturalInputPersonBuilder()
                .name(makeName("John Doe"))
                .addEmail(EmailAddressFactory.forAddress("dqwdqw@dsds.sddsa"))
                .age(AgeInfoFactory.forDate(1861, 3, 3))
                .build();

        RiskDetectorResult result = run(person);
        assertTrue(result.getRisks().size() >= 3);
    }

    private RiskDetectorResult run(InputPerson person) throws Exception {
        PersonRiskDetectorCommand command = new PersonRiskDetectorCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        return executor.execute(command, mode, person).get();
    }
}