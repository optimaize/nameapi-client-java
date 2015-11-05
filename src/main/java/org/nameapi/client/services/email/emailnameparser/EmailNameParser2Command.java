package org.nameapi.client.services.email.emailnameparser;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.ontology5.services.email.emailnameparser.EmailNameParserResult;

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
        extends NameApiBaseCommand<RestPort, String, EmailNameParserResult>
{


    private static final String SERVICE_PATH = "/email/emailnameparser2";

    public EmailNameParser2Command() {
        super(RestPort.class);
    }

    @Override @NotNull
    public EmailNameParserResult call(@NotNull Optional<String> arg, @NotNull ExecutionContext ec) throws Exception {
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

