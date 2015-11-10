package org.nameapi.client.services.matcher.personmatcher;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.ontology5.services.matcher.personmatcher.PersonMatcherResult;

import java.util.concurrent.Callable;

/**
 * Compares two people and tells if and how they match.
 */
public class PersonMatcherCommand
        extends NameApiBaseCommand<RestPort, PersonMatcherArgument, PersonMatcherResult>
{

    private static final String SERVICE_PATH = "/matcher/personmatcher";

    public PersonMatcherCommand() {
        super(RestPort.class);
    }

    @Override
    public PersonMatcherResult call(@NotNull Optional<PersonMatcherArgument> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).call(getApiKey(ec), getContext(ec), arg.get().getInputPerson1(), arg.get().getInputPerson2());
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
