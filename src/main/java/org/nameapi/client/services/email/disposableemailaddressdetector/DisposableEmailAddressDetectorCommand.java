package org.nameapi.client.services.email.disposableemailaddressdetector;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.ontology5.services.email.disposableemailaddressdetector.DisposableEmailAddressDetectorResult;

import java.util.concurrent.Callable;

/**
 * Detects disposable email addresses "DEA", also known as trash email addresses such as "foo@mailinator.com".
 *
 * <p>Detects thousands of known dea domains.</p>
 *
 * <p>It classifies those as disposable which operate as a time-limited, web based way of receiving emails,
 * for example, sign up confirmations.</p>
 *
 * <p>Essentially every email address may be of temporary use. Even freemail providers like yahoo and gmail
 * offer [temporary] aliases. However, those are personal and may be in use for a longer period of time,
 * and can often not be detected as such.</p>
 */
public class DisposableEmailAddressDetectorCommand
        extends NameApiBaseCommand<RestPort, String, DisposableEmailAddressDetectorResult>
{

    private static final String SERVICE_PATH = "/email/disposableemailaddressdetector";

    public DisposableEmailAddressDetectorCommand() {
        super(RestPort.class);
    }

    @Override @NotNull
    public DisposableEmailAddressDetectorResult call(@NotNull Optional<String> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).call(getApiKey(ec), arg.get());
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
