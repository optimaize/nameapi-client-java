package org.nameapi.client.services.genderizer.persongenderizer;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.services.genderizer.GenderizerResult;

import java.util.concurrent.Callable;

/**
 * Attempts to detect the person's gender based on the inputs, especially the person's name.
 */
public class PersonGenderizerCommand
        extends NameApiBaseCommand<RestPort, InputPerson, GenderizerResult>
{

    private static final String SERVICE_PATH = "/genderizer/persongenderizer";

    public PersonGenderizerCommand() {
        super(RestPort.class);
    }

    @Override
    public GenderizerResult call(@NotNull Optional<InputPerson> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).call(getApiKey(ec), getContext(ec), arg.get());
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
