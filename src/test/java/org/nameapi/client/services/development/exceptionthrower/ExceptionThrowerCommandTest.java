package org.nameapi.client.services.development.exceptionthrower;

import com.optimaize.anythingworks.common.fault.exceptions.AccessDeniedServiceException;
import com.optimaize.anythingworks.common.fault.exceptions.BadRequestServiceException;
import com.optimaize.anythingworks.common.fault.exceptions.InternalServerErrorServiceException;
import com.optimaize.anythingworks.common.fault.faultinfo.Blame;
import com.optimaize.anythingworks.common.fault.faultinfo.RetryType;
import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import org.nameapi.client.services.FunctionalTestsNameApiModeFactory;
import org.nameapi.client.lib.NameApiRemoteExecutors;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

/**
 */
public class ExceptionThrowerCommandTest {

    private final CommandExecutor executor = NameApiRemoteExecutors.get();

    @Test
    public void testCall1() throws Exception {
        try {
            execute(ExceptionType.InvalidInput);
            fail("Expected exception!");
        } catch (BadRequestServiceException e) {
            assertEquals(e.getFaultInfo().getBlame(), Blame.CLIENT);
            assertEquals(e.getFaultInfo().getRetrySameLocation().get().getRetryType(), RetryType.NO);
        }
    }

    @Test
    public void testCall2() throws Exception {
        try {
            execute(ExceptionType.InternalServerError);
            fail("Expected exception!");
        } catch (InternalServerErrorServiceException e) {
            assertEquals(e.getFaultInfo().getBlame(), Blame.SERVER);
            assertFalse(e.getFaultInfo().getRetrySameLocation().isPresent());
        }
    }


    @Test
    public void testCall3() throws Exception {
        try {
            execute(ExceptionType.AccessDeniedNoSuchAccount);
            fail("Expected exception!");
        } catch (AccessDeniedServiceException e) {
            assertEquals(e.getFaultInfo().getBlame(), Blame.CLIENT);
            assertEquals(e.getFaultInfo().getRetrySameLocation().get().getRetryType(), RetryType.NO);
        }
    }

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
        executor.execute(command, mode, new ExceptionThrowerParams(type, 100)).get();
    }
}
