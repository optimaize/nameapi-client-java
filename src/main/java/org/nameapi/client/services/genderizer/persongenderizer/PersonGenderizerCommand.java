package org.nameapi.client.services.genderizer.persongenderizer;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.genderizer.PersonGenderizerResult;
import org.nameapi.client.services.genderizer.persongenderizer.wsdl.SoapPersonGenderizer;
import org.nameapi.client.services.genderizer.persongenderizer.wsdl.SoapPersonGenderizerResult;
import org.nameapi.client.services.genderizer.persongenderizer.wsdl.SoapPersonGenderizerService;
import org.nameapi.ontology4.input.entities.person.InputPerson;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Attempts to detect the person's gender based on the inputs, especially the person's name.
 */
public class PersonGenderizerCommand
        extends NameApiBaseCommand<SoapPersonGenderizer, InputPerson, PersonGenderizerResult>
{

    private static final String servicePath = "/genderizer/persongenderizer";

    public PersonGenderizerCommand() {
        super(SoapPersonGenderizer.class);
    }

    @Override @NotNull
    public PersonGenderizerResult call(@NotNull Optional<InputPerson> arg, @NotNull ExecutionContext ec) throws Exception {
        SoapPersonGenderizerResult result = getPort(ec).assess(getContext(ec), Conversions.convert(arg.get()));
        return convert(result);
    }

    private PersonGenderizerResult convert(SoapPersonGenderizerResult result) {
        return new PersonGenderizerResult(
                result.getGender(),
                result.getMaleProportion(),
                result.getConfidence()
        );
    }


    @NotNull @Override
    protected Callable<SoapPersonGenderizer> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapPersonGenderizer>() {
            @Override
            public SoapPersonGenderizer call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapPersonGenderizerService(url).getSoapPersonGenderizerPort();
            }
        };
    }

}
