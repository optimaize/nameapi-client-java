package org.nameapi.client.services.system.ping;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class PingCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void testCall() throws Exception {
        PingCommand command = new PingCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        for (int i=0; i<1; i++) {
            assertEquals(executor.execute(command, mode, null).get(), "\"pong\"");
        }
    }
}
