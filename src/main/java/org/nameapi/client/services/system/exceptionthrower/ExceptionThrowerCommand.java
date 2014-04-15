package org.nameapi.client.services.system.exceptionthrower;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.commonwsdl.context.SoapContext;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.system.exceptionthrower.wsdl.SoapExceptionThrower;
import org.nameapi.client.services.system.exceptionthrower.wsdl.SoapExceptionThrowerService;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Tells the server to throw an exception. This is to debug and test on the client how things work.
 */
public class ExceptionThrowerCommand extends NameApiBaseCommand<SoapExceptionThrower, ExceptionType, String> {

    private static final String servicePath = "/system/exceptionthrower";

    public ExceptionThrowerCommand() {
        super(SoapExceptionThrower.class);
    }

    @Override
    public String call(@NotNull Optional<ExceptionType> arg, @NotNull ExecutionContext ec) throws Exception {
        SoapExceptionThrower port = getPort(ec);
        SoapContext context = getContext(ec);
        ExceptionType.assertSize(5);
        switch (arg.get()) {
            case InvalidInput:
                return port.throwInvalidInput(context);
            case Internal:
                return port.throwInternal(context);
            case AccessDeniedNoSuchAccount:
                return port.throwAccessDeniedNoSuchAccount(context);
            case AccessDeniedRequestLimitExceeded:
                return port.throwAccessDeniedRequestLimitExceeded(context);
            case AccessDeniedTooManyConcurrentRequests:
                return port.throwAccessDeniedTooManyConcurrentRequests(context);
            default:
                throw new AssertionError("Dead code reached!");
        }
    }

    @NotNull @Override
    protected Callable<SoapExceptionThrower> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapExceptionThrower>() {
            @Override
            public SoapExceptionThrower call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapExceptionThrowerService(url).getSoapExceptionThrowerPort();
            }
        };
    }

}
