package org.nameapi.client.services.system.pinger;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.NameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class PingerCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void testCall() throws Exception {
        PingerCommand command = new PingerCommand();
        Mode mode = NameApiModeFactory.functionalTest();
        for (int i=0; i<10; i++) {
            assertEquals(executor.execute(command, mode, null).get().getPong(), "pong");
        }
    }
}
