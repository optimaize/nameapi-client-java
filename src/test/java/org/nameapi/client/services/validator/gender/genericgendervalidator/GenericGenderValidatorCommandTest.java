package org.nameapi.client.services.validator.gender.genericgendervalidator;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;

import static org.testng.Assert.assertEquals;

/**
 * Service currently not available as public API.
 */
public class GenericGenderValidatorCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

//    @Test
    public void testCall() throws Exception {
        GenericGenderValidatorCommand command = new GenericGenderValidatorCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("John", "Doe"))
                .gender(StoragePersonGender.MALE)
        .build();
//        assertEquals(executor.execute(command, mode, person).get().getType(), GenderValidationResultType.CORRECT);
    }

//    @Test(expectedExceptions = InvalidInputServiceException.class)
//    public void testCall2() throws Exception {
//        GenericGenderValidatorCommand command = new GenericGenderValidatorCommand();
//        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
//        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName("John", "Doe"))
//        .build();
//        executor.execute(command, mode, person);
//    }

}
