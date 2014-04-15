package org.nameapi.client.services.validator.randomtyping.givennamerandomtypingdetector;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.validator.randomtyping.givennamerandomtypingdetector.wsdl.SoapGivenNameRandomTypingDetector;
import org.nameapi.client.services.validator.randomtyping.givennamerandomtypingdetector.wsdl.SoapGivenNameRandomTypingDetectorService;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * ...
 */
public class GivenNameRandomTypingDetectorCommand
        extends NameApiBaseCommand<SoapGivenNameRandomTypingDetector, String, Integer>
{

    private static final String servicePath = "/validator/randomtypingdetector/givennamefield";

    public GivenNameRandomTypingDetectorCommand() {
        super(SoapGivenNameRandomTypingDetector.class);
    }

    @Override @Nullable
    public Integer call(@NotNull Optional<String> arg, @NotNull ExecutionContext ec) throws Exception {
        return getPort(ec).checkField(getContext(ec), arg.get());
    }


    @NotNull @Override
    protected Callable<SoapGivenNameRandomTypingDetector> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapGivenNameRandomTypingDetector>() {
            @Override
            public SoapGivenNameRandomTypingDetector call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapGivenNameRandomTypingDetectorService(url).getSoapGivenNameRandomTypingDetectorPort();
            }
        };
    }

}
