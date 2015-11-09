package org.nameapi.client.services.development.exceptionthrower;

import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;

/**
 */
public class ExceptionThrowerCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

//    @Test(expectedExceptions = InvalidInputServiceException.class)
//    public void testCall1() throws Exception {
//        execute(ExceptionType.InvalidInput);
//    }
//
//    @Test(expectedExceptions = InternalServiceException.class)
//    public void testCall2() throws Exception {
//        execute(ExceptionType.Internal);
//    }
//
//
//    @Test(expectedExceptions = AccessDeniedServiceException.class)
//    public void testCall3() throws Exception {
//        execute(ExceptionType.AccessDeniedNoSuchAccount);
//    }
//
//    @Test(expectedExceptions = AccessDeniedServiceException.class)
//    public void testCall4() throws Exception {
//        execute(ExceptionType.AccessDeniedRequestLimitExceeded);
//    }
//
//    @Test(expectedExceptions = AccessDeniedServiceException.class)
//    public void testCall5() throws Exception {
//        execute(ExceptionType.AccessDeniedTooManyConcurrentRequests);
//    }

    private void execute(ExceptionType type) throws Exception {
        ExceptionThrowerCommand command = new ExceptionThrowerCommand();
        Mode mode = FunctionalTestsNameApiModeFactory.functionalTest();
//        executor.execute(command, mode, type).get();
    }
}