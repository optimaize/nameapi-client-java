package org.nameapi.client.services.system.pinger;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.system.pinger.wsdl.SoapPinger;
import org.nameapi.client.services.system.pinger.wsdl.SoapPingerService;

import java.net.URL;
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
public class PingerCommand extends NameApiBaseCommand<SoapPinger, Void, PingerResult> {

    private static final String servicePath = "/system/pinger";

    public PingerCommand() {
        super(SoapPinger.class);
    }

    @Override
    public PingerResult call(@NotNull Optional<Void> arg, @NotNull ExecutionContext ec) throws Exception {
        return new PingerResult( getPort(ec).ping(getContext(ec)).getPong() );
    }

    @NotNull @Override
    protected Callable<SoapPinger> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapPinger>() {
            @Override
            public SoapPinger call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapPingerService(url).getSoapPingerPort();
            }
        };
    }

}
