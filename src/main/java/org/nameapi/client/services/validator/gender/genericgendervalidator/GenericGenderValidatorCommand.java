package org.nameapi.client.services.validator.gender.genericgendervalidator;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.validator.gender.genericgendervalidator.wsdl.SoapGenderValidationResult;
import org.nameapi.client.services.validator.gender.genericgendervalidator.wsdl.SoapGenericGenderValidator;
import org.nameapi.client.services.validator.gender.genericgendervalidator.wsdl.SoapGenericGenderValidatorService;
import org.nameapi.ontology4.input.entities.person.InputPerson;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * ...
 */
public class GenericGenderValidatorCommand
        extends NameApiBaseCommand<SoapGenericGenderValidator, InputPerson, GenderValidationResult>
{

    private static final String servicePath = "/validator/gender/genericgendervalidator";

    public GenericGenderValidatorCommand() {
        super(SoapGenericGenderValidator.class);
    }

    @Override @NotNull
    public GenderValidationResult call(@NotNull Optional<InputPerson> arg, @NotNull ExecutionContext ec) throws Exception {
        SoapGenderValidationResult result = getPort(ec).validate(getContext(ec), Conversions.convert(arg.get()));
        return convert(result);
    }

    private GenderValidationResult convert(SoapGenderValidationResult result) {
        return new GenderValidationResult(
                result.getConfidence(),
                result.getReasoning(),
                result.getType(),
                result.getWrongChance()
        );
    }


    @NotNull @Override
    protected Callable<SoapGenericGenderValidator> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapGenericGenderValidator>() {
            @Override
            public SoapGenericGenderValidator call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapGenericGenderValidatorService(url).getSoapGenericGenderValidatorPort();
            }
        };
    }

}
