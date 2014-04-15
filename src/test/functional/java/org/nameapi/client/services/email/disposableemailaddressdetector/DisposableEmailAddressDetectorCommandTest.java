package org.nameapi.client.services.email.disposableemailaddressdetector;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import crema.lang.Maybe;
import org.nameapi.client.services.NameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class DisposableEmailAddressDetectorCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();


    @Test
    public void testCall() throws Exception {
        DisposableEmailAddressDetectorCommand command = new DisposableEmailAddressDetectorCommand();
        Mode mode = NameApiModeFactory.functionalTest();
        assertEquals(executor.execute(command, mode, "blahblah@10minutemail.com").get(), Maybe.YES);
    }
}
