package org.nameapi.client.services.validator.randomtyping.givennamerandomtypingdetector;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.validator.randomtyping.RandomTypingResult;

import java.util.concurrent.Callable;

/**
 * Service currently not available as public API.
 *
 *
 */
public class GivenNameRandomTypingDetectorCommand extends NameApiBaseCommand<RestPort, String, RandomTypingResult> {

    private static final String SERVICE_PATH = "/validator/randomtypingdetector/givennamefield";

    public GivenNameRandomTypingDetectorCommand() {
        super(RestPort.class);
        throw new UnsupportedOperationException("Service currently not available as public API.");
    }

    @Override
    public RandomTypingResult call(@NotNull Optional<String> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).ping(getApiKey(ec), arg.get());
    }

    @NotNull
    @Override
    protected Callable<RestPort> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<RestPort>() {
            @Override
            public RestPort call() throws Exception {
                return new RestPort(makeClient(ec), SERVICE_PATH);
            }
        };
    }

}
