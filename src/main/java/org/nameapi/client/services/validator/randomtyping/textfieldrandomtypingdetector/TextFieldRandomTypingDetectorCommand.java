package org.nameapi.client.services.validator.randomtyping.textfieldrandomtypingdetector;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.validator.randomtyping.surnamerandomtypingdetector.wsdl.SoapSurnameRandomTypingDetector;
import org.nameapi.client.services.validator.randomtyping.surnamerandomtypingdetector.wsdl.SoapSurnameRandomTypingDetectorService;
import org.nameapi.client.services.validator.randomtyping.textfieldrandomtypingdetector.wsdl.SoapTextFieldRandomTypingDetector;
import org.nameapi.client.services.validator.randomtyping.textfieldrandomtypingdetector.wsdl.SoapTextFieldRandomTypingDetectorService;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * ...
 */
public class TextFieldRandomTypingDetectorCommand
        extends NameApiBaseCommand<SoapTextFieldRandomTypingDetector, String, Integer>
{

    private static final String servicePath = "/validator/randomtypingdetector/textfield";

    public TextFieldRandomTypingDetectorCommand() {
        super(SoapTextFieldRandomTypingDetector.class);
    }

    @Override @Nullable
    public Integer call(@NotNull Optional<String> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).check(getContext(ec), arg.get());
    }


    @NotNull @Override
    protected Callable<SoapTextFieldRandomTypingDetector> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapTextFieldRandomTypingDetector>() {
            @Override
            public SoapTextFieldRandomTypingDetector call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapTextFieldRandomTypingDetectorService(url).getSoapTextFieldRandomTypingDetectorPort();
            }
        };
    }

}
