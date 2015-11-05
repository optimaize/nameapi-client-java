package org.nameapi.client.services.system.exceptionthrower;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;

import java.util.concurrent.Callable;

/**
 * Tells the server to throw an exception. This is to debug and test on the client how things work.
 */
public class ExceptionThrowerCommand extends NameApiBaseCommand<RestPort, ExceptionThrowerParams, String> {

//    @Override
//    public String call(@NotNull Optional<ExceptionType> arg, @NotNull ExecutionContext ec) throws Exception {
//        SoapExceptionThrower port = getPort(ec);
//        SoapContext context = getContext(ec);
//        ExceptionType.assertSize(5);
//        switch (arg.get()) {
//            case InvalidInput:
//                return port.throwInvalidInput(context);
//            case Internal:
//                return port.throwInternal(context);
//            case AccessDeniedNoSuchAccount:
//                return port.throwAccessDeniedNoSuchAccount(context);
//            case AccessDeniedRequestLimitExceeded:
//                return port.throwAccessDeniedRequestLimitExceeded(context);
//            case AccessDeniedTooManyConcurrentRequests:
//                return port.throwAccessDeniedTooManyConcurrentRequests(context);
//            default:
//                throw new AssertionError("Dead code reached!");
//        }
//    }





    private static final String SERVICE_PATH = "/system/exceptionthrower";

    public ExceptionThrowerCommand() {
        super(RestPort.class);
    }

    @Override
    public String call(@NotNull Optional<ExceptionThrowerParams> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).call(getApiKey(ec));
    }

    @NotNull @Override
    protected Callable<RestPort> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<RestPort>() {
            @Override
            public RestPort call() throws Exception {
                return new RestPort(makeClient(ec), SERVICE_PATH);
            }
        };
    }

}
