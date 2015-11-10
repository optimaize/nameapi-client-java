package org.nameapi.client.services.system.ping;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;

import java.util.concurrent.Callable;

/**
 * The ping command simply pings the server and, on success, gets a "pong" back.
 *
 * <p>Ping can be used either manually or by code to check for service availability and response time.</p>
 *
 * <p>The command passes through all interceptors (authentication, load balancing etc.) to a target server
 * that actually executes nameapi requests. All standard behavior applies including request
 * prioritization and request limits per contract. The only difference is that the minimal response time
 * used on free accounts is not applied.</p>
 *
 * @author eike, andrej
 */
public class PingCommand extends NameApiBaseCommand<RestPort, Void, String> {

    private static final String SERVICE_PATH = "/system/ping";

    public PingCommand() {
        super(RestPort.class);
    }

    @Override
    public String call(@NotNull Optional<Void> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).ping(getApiKey(ec));
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
