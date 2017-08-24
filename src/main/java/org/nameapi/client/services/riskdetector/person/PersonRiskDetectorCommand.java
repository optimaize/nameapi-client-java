package org.nameapi.client.services.riskdetector.person;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.ontology5.input.entities.person.InputPerson;
import org.nameapi.ontology5.services.riskdetector.RiskDetectorResult;

import java.util.concurrent.Callable;

public class PersonRiskDetectorCommand extends NameApiBaseCommand<RestPort, InputPerson, RiskDetectorResult> {

    private static final String SERVICE_PATH = "/riskdetector/person";

    public PersonRiskDetectorCommand() {
        super(RestPort.class);
    }

    @Nullable
    @Override
    public RiskDetectorResult call(@NotNull Optional<InputPerson> inputPersonOpt, @NotNull ExecutionContext context) throws Exception {
        return getPort(context).call(getApiKey(context), getContext(context), inputPersonOpt.get());
    }

    @NotNull
    @Override
    protected Callable<RestPort> createPort(@NotNull final ExecutionContext context) {
        return new Callable<RestPort>() {
            @Override
            public RestPort call() throws Exception {
                return new RestPort(makeClient(context), SERVICE_PATH);
            }
        };
    }
}
