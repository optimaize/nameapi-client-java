package org.nameapi.client.services.validator.randomtyping.givennamerandomtypingdetector;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.NameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * ...
 */
public class GivenNameRandomTypingDetectorCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(dataProvider="testSome")
    public void testSome(String name, int minIncl, int maxIncl) throws Exception {
        GivenNameRandomTypingDetectorCommand command = new GivenNameRandomTypingDetectorCommand();
        Mode mode = NameApiModeFactory.functionalTest();
        Integer result = executor.execute(command, mode, name).get();
        assertTrue(result >= minIncl && result <= maxIncl);
    }

    @DataProvider(name="testSome")
    public Object[][] testSome() {
        return new Object[][] {
                {"asdf",         100, 100},
                {"Peter",          0,  10},
        };
    }

}
