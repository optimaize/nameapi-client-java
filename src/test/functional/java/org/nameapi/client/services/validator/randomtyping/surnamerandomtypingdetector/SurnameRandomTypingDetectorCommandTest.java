package org.nameapi.client.services.validator.randomtyping.surnamerandomtypingdetector;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * ...
 */
public class SurnameRandomTypingDetectorCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider="testSome")
    public void testSome(String name, int minIncl, int maxIncl) throws Exception {
        SurnameRandomTypingDetectorCommand command = new SurnameRandomTypingDetectorCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        Integer result = executor.execute(command, mode, name).get();
        assertTrue(result >= minIncl && result <= maxIncl);
    }

    @DataProvider(name="testSome")
    public Object[][] testSome() {
        return new Object[][] {
                {"asdf",         100, 100},
                {"Johnson",        0,  10},
        };
    }

}
