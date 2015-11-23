package org.nameapi.client.services.development.exceptionthrower;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;

import java.util.concurrent.Callable;

/**
 * Tells the server to throw an exception. This is to debug and test on the client how things work.
 */
public class ExceptionThrowerCommand extends NameApiBaseCommand<RestPort, ExceptionThrowerParams, String> {

    private static final String SERVICE_PATH = "/development/exceptionthrower";

    public ExceptionThrowerCommand() {
        super(RestPort.class);
    }

    @Override
    public String call(@NotNull Optional<ExceptionThrowerParams> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).call(getApiKey(ec), arg.get().getExceptionType(), arg.get().getExceptionChance());
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
