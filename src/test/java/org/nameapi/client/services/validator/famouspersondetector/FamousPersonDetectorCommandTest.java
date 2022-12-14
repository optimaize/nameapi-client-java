package org.nameapi.client.services.validator.famouspersondetector;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.client.services.AbstractTest;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.ontology5.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology5.input.entities.person.NaturalInputPersonBuilder;
import org.testng.annotations.DataProvider;

/**
 * Service currently not available as public API.
 */
public class FamousPersonDetectorCommandTest extends AbstractTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

//    @Test(dataProvider="people")
    public void people(String gn, String sn, Integer minIncl, Integer maxIncl) throws Exception {
        FamousPersonDetectorCommand command = new FamousPersonDetectorCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        NaturalInputPerson person = new NaturalInputPersonBuilder().name(makeName(gn, sn)).build();
//        Optional<FamousPersonResult> oResult = executor.execute(command, mode, person);
//        if (minIncl==null && maxIncl==null) {
//            assertFalse(oResult.isPresent());
//        } else {
//            int points = oResult.get().getPoints();
//            assertTrue(points >= minIncl && points <= maxIncl);
//        }
    }

    @DataProvider(name="people")
    public Object[][] people() {
        return new Object[][] {
//                {"George", "Bush", 60, 100},
//                {"Angela", "Merkel", 60, 100},
//                {"Daniela", "Doesnotexisst", null, null},
                {"Fifafoo", "Falalagazz", null, null},
                {"Fifafoo", "", null, null},
                {"", "Falalagazz", null, null},
                {"", "", null, null},
        };
    }


}
