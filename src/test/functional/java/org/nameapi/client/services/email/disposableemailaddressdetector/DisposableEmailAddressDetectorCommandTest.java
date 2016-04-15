package org.nameapi.client.services.email.disposableemailaddressdetector;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.nameapi.ontology5.cremalang.lang.Maybe;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 */
public class DisposableEmailAddressDetectorCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();


    @Test
    public void testCall() throws Exception {
        DisposableEmailAddressDetectorCommand command = new DisposableEmailAddressDetectorCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
        assertEquals(executor.execute(command, mode, "blahblah@10minutemail.com").get().getDisposable(), Maybe.YES);
    }
}
