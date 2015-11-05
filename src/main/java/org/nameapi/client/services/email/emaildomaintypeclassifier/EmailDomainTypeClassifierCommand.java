package org.nameapi.client.services.email.emaildomaintypeclassifier;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.ontology5.services.email.emaildomaintypeclassifier.EmailDomainTypeClassifierResult;

import java.util.concurrent.Callable;

/**
 * Classifies the domain name of an email address as FREEMAIL, ORGANIZATION etc.
 *
 * <p>Examples:
 * john.doe@gmail.com uses a FREEMAIL domain.
 * john.doe@google.com uses an ORGANIZATION domain.
 * </p>
 *
 * <p>Note that there is not always a clear line between domain types. Especially FREEMAIL and ISP
 * are blurry; freemail providers often offer extended paid packages, while internet service providers
 * sometimes often a basic free email account.</p>
 */
public class EmailDomainTypeClassifierCommand
        extends NameApiBaseCommand<RestPort, String, EmailDomainTypeClassifierResult>
{


    private static final String SERVICE_PATH = "/email/emaildomaintypeclassifier";

    public EmailDomainTypeClassifierCommand() {
        super(RestPort.class);
    }

    @Override @NotNull
    public EmailDomainTypeClassifierResult call(@NotNull Optional<String> arg, @NotNull ExecutionContext ec) throws Exception {
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
