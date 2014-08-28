package org.nameapi.client.services.validator.randomtyping.personrandomtypingdetector;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.validator.randomtyping.personrandomtypingdetector.wsdl.SoapPersonRandomTypingDetector;
import org.nameapi.client.services.validator.randomtyping.personrandomtypingdetector.wsdl.SoapPersonRandomTypingDetectorService;
import org.nameapi.ontology4.input.entities.person.InputPerson;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * ...
 */
public class PersonRandomTypingDetectorCommand
        extends NameApiBaseCommand<SoapPersonRandomTypingDetector, InputPerson, Integer>
{

    private static final String servicePath = "/validator/randomtypingdetector/person";

    public PersonRandomTypingDetectorCommand() {
        super(SoapPersonRandomTypingDetector.class);
    }

    @Override @Nullable
    public Integer call(@NotNull Optional<InputPerson> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).checkPerson(getContext(ec), Conversions.convert(arg.get()));
    }


    @NotNull @Override
    protected Callable<SoapPersonRandomTypingDetector> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapPersonRandomTypingDetector>() {
            @Override
            public SoapPersonRandomTypingDetector call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapPersonRandomTypingDetectorService(url).getSoapPersonRandomTypingDetectorPort();
            }
        };
    }

}
