package org.nameapi.client.services.email.disposableemailaddressdetector;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import crema.lang.Maybe;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.email.disposableemailaddressdetector.wsdl.SoapDisposableEmailAddressDetector;
import org.nameapi.client.services.email.disposableemailaddressdetector.wsdl.SoapDisposableEmailAddressDetectorService;

import java.net.URL;
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
        extends NameApiBaseCommand<SoapDisposableEmailAddressDetector, String, Maybe>
{

    private static final String servicePath = "/email/disposableemailaddressdetector";

    public DisposableEmailAddressDetectorCommand() {
        super(SoapDisposableEmailAddressDetector.class);
    }

    @Override @NotNull
    public Maybe call(@NotNull Optional<String> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).isDisposable(getContext(ec), arg.get()).getDisposable();
    }

    @NotNull @Override
    protected Callable<SoapDisposableEmailAddressDetector> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapDisposableEmailAddressDetector>() {
            @Override
            public SoapDisposableEmailAddressDetector call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapDisposableEmailAddressDetectorService(url).getSoapDisposableEmailAddressDetectorPort();
            }
        };
    }

}
