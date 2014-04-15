package org.nameapi.client.services.email.emaildomaintypeclassifier;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.email.emaildomaintypeclassifier.wsdl.EmailDomainType;
import org.nameapi.client.services.email.emaildomaintypeclassifier.wsdl.SoapEmailDomainTypeClassifier;
import org.nameapi.client.services.email.emaildomaintypeclassifier.wsdl.SoapEmailDomainTypeClassifierService;

import java.net.URL;
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
        extends NameApiBaseCommand<SoapEmailDomainTypeClassifier, String, EmailDomainType>
{

    private static final String servicePath = "/email/emaildomaintypeclassifier";

    public EmailDomainTypeClassifierCommand() {
        super(SoapEmailDomainTypeClassifier.class);
    }

    @Override @NotNull
    public EmailDomainType call(@NotNull Optional<String> arg, @NotNull ExecutionContext ec) throws Exception {
        if (true) throw new UnsupportedOperationException("This service is currently not enabled.");
        return getPort(ec).classify(getContext(ec), arg.get());
    }

    @NotNull @Override
    protected Callable<SoapEmailDomainTypeClassifier> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapEmailDomainTypeClassifier>() {
            @Override
            public SoapEmailDomainTypeClassifier call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapEmailDomainTypeClassifierService(url).getSoapEmailDomainTypeClassifierPort();
            }
        };
    }

}
