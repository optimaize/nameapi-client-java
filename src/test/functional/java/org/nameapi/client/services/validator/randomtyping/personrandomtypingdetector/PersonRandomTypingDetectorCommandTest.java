package org.nameapi.client.services.validator.randomtyping.personrandomtypingdetector;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Service currently not available as public API.
 */
public class PersonRandomTypingDetectorCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

//    @Test(dataProvider="testSome")
    public void testSome(String gn, String sn, int minIncl, int maxIncl) throws Exception {
        PersonRandomTypingDetectorCommand command = new PersonRandomTypingDetectorCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName(gn, sn)).build();
//        Integer result = executor.execute(command, mode, person).get();
//        assertTrue(result >= minIncl && result <= maxIncl);
    }

    @DataProvider(name="testSome")
    public Object[][] testSome() {
        return new Object[][] {
                {"asdf",  "asdf",         100, 100},
                {"Peter",  "Johnson",       0,  10},
        };
    }

}
