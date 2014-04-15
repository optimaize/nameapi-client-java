package org.nameapi.client.services.system.exceptionthrower;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import com.optimaize.soapworks.client.exception.AccessDeniedServiceException;
import com.optimaize.soapworks.client.exception.InternalServiceException;
import com.optimaize.soapworks.client.exception.InvalidInputServiceException;
import org.nameapi.client.services.NameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.testng.annotations.Test;

/**
 */
public class ExceptionThrowerCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test(expectedExceptions = InvalidInputServiceException.class)
    public void testCall1() throws Exception {
        execute(ExceptionType.InvalidInput);
    }

    @Test(expectedExceptions = InternalServiceException.class)
    public void testCall2() throws Exception {
        execute(ExceptionType.Internal);
    }


    @Test(expectedExceptions = AccessDeniedServiceException.class)
    public void testCall3() throws Exception {
        execute(ExceptionType.AccessDeniedNoSuchAccount);
    }

    @Test(expectedExceptions = AccessDeniedServiceException.class)
    public void testCall4() throws Exception {
        execute(ExceptionType.AccessDeniedRequestLimitExceeded);
    }

    @Test(expectedExceptions = AccessDeniedServiceException.class)
    public void testCall5() throws Exception {
        execute(ExceptionType.AccessDeniedTooManyConcurrentRequests);
    }

    private void execute(ExceptionType type) throws Exception {
        ExceptionThrowerCommand command = new ExceptionThrowerCommand();
        Mode mode = NameApiModeFactory.functionalTest();
        executor.execute(command, mode, type).get();
    }
}
