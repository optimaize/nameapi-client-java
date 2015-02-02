package org.nameapi.client.services.email.emailnameparser2;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.email.emailnameparser.EmailNameParserMatch;
import org.nameapi.client.services.email.emailnameparser.EmailNameParserMatchImpl;
import org.nameapi.client.services.email.emailnameparser.NameFromEmailAddress;
import org.nameapi.client.services.email.emailnameparser.NameFromEmailAddressImpl;
import org.nameapi.client.services.email.emailnameparser2.wsdl.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Analyzes the email address and attempts to extract a person's name.
 *
 * <p>Example: john.doe@example.com => [john, doe]</p>
 *
 * <p>The service attempts to detect several kinds of syntax, such as:
 * <ul>
 *     <li>peter.johnson@example.com</li>
 *     <li>peter.a.johnson@example.com</li>
 *     <li>peterjohnson@example.com</li>
 *     <li>pjohnson@example.com</li>
 *     <li>peterj@example.com</li>
 *     <li>peter@example.com</li>
 *     <li>johnson@example.com</li>
 *     <li>johnson.peter@example.com</li>
 *     <li>johnsonpeter@example.com</li>
 * </ul>
 * </p>
 *
 * <p>Names are not formatted to correct case, they are left the way they appeared in the input.</p>
 *
 * <p>Difference to the older EmailNameParserCommand:
 * The enum EmailAddressParsingResultType2 uses FUNCTIONAL instead of DEPARTMENT and TECHNICAL because the two can hardly be told apart.
 * </p>
 */
public class EmailNameParser2Command
        extends NameApiBaseCommand<SoapEmailNameParser2, String, EmailNameParser2Result>
{

    private static final String servicePath = "/email/emailnameparser2";

    public EmailNameParser2Command() {
        super(SoapEmailNameParser2.class);
    }

    @Override @NotNull
    public EmailNameParser2Result call(@NotNull Optional<String> arg, @NotNull ExecutionContext ec) throws Exception {
        SoapEmailNameParserResult2 soapResult = getPort(ec).parse(getContext(ec), arg.get());
        return convert(soapResult);
    }

    @NotNull
    private EmailNameParser2Result convert(@NotNull SoapEmailNameParserResult2 soapResult) {
        List<EmailNameParserMatch> matches = new ArrayList<>();
        for (SoapEmailNameParserMatch soapMatch : soapResult.getMatches()) {
            matches.add( convert(soapMatch) );
        }
        return new EmailNameParser2ResultImpl(soapResult.getResultType(), matches);
    }
    @NotNull
    private EmailNameParserMatch convert(@NotNull SoapEmailNameParserMatch soapMatch) {
        return new EmailNameParserMatchImpl(
                convert(soapMatch.getGivenNames()),
                convert(soapMatch.getSurnames()),
                soapMatch.getConfidence()
        );
    }
    @NotNull
    private List<NameFromEmailAddress> convert(@NotNull List<SoapNameFromEmailAddress> list) {
        List<NameFromEmailAddress> ret = new ArrayList<>();
        for (SoapNameFromEmailAddress soapName : list) {
            ret.add(convert(soapName));
        }
        return ret;
    }
    @NotNull
    private NameFromEmailAddress convert(@NotNull SoapNameFromEmailAddress soapName) {
        return new NameFromEmailAddressImpl(soapName.getName(), soapName.getNameType());
    }

    @NotNull @Override
    protected Callable<SoapEmailNameParser2> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapEmailNameParser2>() {
            @Override
            public SoapEmailNameParser2 call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapEmailNameParser2Service(url).getSoapEmailNameParser2Port();
            }
        };
    }

}

