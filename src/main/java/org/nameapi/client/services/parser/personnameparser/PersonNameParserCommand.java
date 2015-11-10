package org.nameapi.client.services.parser.personnameparser;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.genderizer.persongenderizer.*;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.services.genderizer.GenderizerResult;
import org.nameapi.ontology5.services.parser.personnameparser.PersonNameParserResult;

import java.util.concurrent.Callable;

/**
 * Parses the name fields of a person's name.
 */
public class PersonNameParserCommand
        extends NameApiBaseCommand<RestPort, InputPerson, PersonNameParserResult>
{


    private static final String SERVICE_PATH = "/parser/personnameparser";

    public PersonNameParserCommand() {
        super(RestPort.class);
    }

    @Override
    public PersonNameParserResult call(@NotNull Optional<InputPerson> arg, @NotNull ExecutionContext ec) throws Exception {
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
