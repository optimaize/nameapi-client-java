package org.nameapi.client.services.formatter.personnameformatter;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.ontology5.services.formatter.FormatterResult;

import java.util.concurrent.Callable;

/**
 * Service for formatting person names.
 *
 * <p>Example: "jean-claude von bergen-meyer" => "Jean-Claude von Bergen-Meyer"</p>
 */
public class PersonNameFormatterCommand
        extends NameApiBaseCommand<RestPort, PersonNameFormatterArgument, FormatterResult>
{

    private static final String SERVICE_PATH = "/formatter/personnameformatter";

    public PersonNameFormatterCommand() {
        super(RestPort.class);
    }

    @Override
    public FormatterResult call(@NotNull Optional<PersonNameFormatterArgument> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).call(getApiKey(ec), getContext(ec), arg.get().getInputPerson(), arg.get().getProperties());
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
