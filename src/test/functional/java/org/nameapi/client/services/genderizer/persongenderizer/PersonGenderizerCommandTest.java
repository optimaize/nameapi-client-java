package org.nameapi.client.services.genderizer.persongenderizer;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.ontology5.input.entities.address.SegregatedPlaceInfoBuilder;
import org.nameapi.ontology5.input.entities.address.SegregatedStreetInfoBuilder;
import org.nameapi.ontology5.input.entities.address.StandardAddressBuilder;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.age.AgeInfoFactory;
import org.nameapi.ontology5.input.entities.person.gender.ComputedPersonGender;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class PersonGenderizerCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void testCall() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("Petra Müller")).build();
        assertEquals(executor.execute(command, mode, person).get().getGender(), ComputedPersonGender.FEMALE);
    }

    @Test
    public void testCall2() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("John", "Doe"))
                //TODO .addTitle("Dr.")
                .age(AgeInfoFactory.forYear(1950))
                .addNationality("US")
                .addNativeLanguage("en")
                .correspondenceLanguage("en")
                .addAddressForAll(new StandardAddressBuilder()
                                .setPlaceInfo(
                                        new SegregatedPlaceInfoBuilder()
                                                .postalCode("90210")
                                                .locality("Beverly Hills")
                                                .country("US")
                                                .build()
                                )
                                .setStreetInfo(
                                        new SegregatedStreetInfoBuilder()
                                        .streetName("Hill road")
                                        .streetNumber("512")
                                        .build()
                                )
                                .build()
                )
        .build();
        assertEquals(executor.execute(command, mode, person).get().getGender(), ComputedPersonGender.MALE);
    }

    /**
     * Using an empty surname field.
     */
    @Test
    public void testCall3() throws Exception {
        PersonGenderizerCommand command = new PersonGenderizerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("John", "")).build();
        assertEquals(executor.execute(command, mode, person).get().getGender(), ComputedPersonGender.MALE);
    }

//    /**
//     * Passing the gender is invalid because if it's already known it can only be validated (use another service).
//     */
//    @Test(expectedExceptions = InvalidInputServiceException.class)
//    public void testCall_ex() throws Exception {
//        PersonGenderizerCommand command = new PersonGenderizerCommand();
//        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
//        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("John", "Doe"))
//                .gender(StoragePersonGender.MALE)
//        .build();
//        executor.execute(command, mode, person);
//    }
}
