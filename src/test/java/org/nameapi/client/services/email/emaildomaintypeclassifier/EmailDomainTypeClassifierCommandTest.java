package org.nameapi.client.services.email.emaildomaintypeclassifier;

import com.optimaize.command4j.Mode;
import com.optimaize.command4j.CommandExecutor;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;

import static org.testng.Assert.assertEquals;

/**
 */
public class EmailDomainTypeClassifierCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();


    //Service currently not available as public API.
//    @Test
    public void testCall() throws Exception {
        EmailDomainTypeClassifierCommand command = new EmailDomainTypeClassifierCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
//        assertEquals(executor.execute(command, mode, "blahblah@10minutemail.com").get(), EmailDomainType.DISPOSABLE);
    }
}
