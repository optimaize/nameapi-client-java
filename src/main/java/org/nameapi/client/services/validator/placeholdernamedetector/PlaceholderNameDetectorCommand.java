package org.nameapi.client.services.validator.placeholdernamedetector;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.validator.placeholdernamedetector.wsdl.SoapPlaceholderNameDetector;
import org.nameapi.client.services.validator.placeholdernamedetector.wsdl.SoapPlaceholderNameDetectorService;
import org.nameapi.client.services.validator.placeholdernamedetector.wsdl.SoapPlaceholderNameResult;
import org.nameapi.ontology.input.entities.person.InputPerson;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Detects placeholder names such as "John Doe".
 *
 * <p>Returns <code>null</code> if the name is not known as a placeholder name.</p>
 */
public class PlaceholderNameDetectorCommand
        extends NameApiBaseCommand<SoapPlaceholderNameDetector, InputPerson, PlaceholderNameResult>
{

    private static final String servicePath = "/validator/placeholdernamedetector";

    public PlaceholderNameDetectorCommand() {
        super(SoapPlaceholderNameDetector.class);
    }

    @Override @Nullable
    public PlaceholderNameResult call(@NotNull Optional<InputPerson> arg, @NotNull ExecutionContext ec) throws Exception {
        SoapPlaceholderNameResult result = getPort(ec).checkPerson(getContext(ec), Conversions.convert(arg.get()));
        if (result==null) return null;
        return convert(result);
    }

    private PlaceholderNameResult convert(SoapPlaceholderNameResult result) {
        return new PlaceholderNameResult(
                result.getFakeType(),
                result.getPoints(),
                result.getMessage()
        );
    }


    @NotNull @Override
    protected Callable<SoapPlaceholderNameDetector> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapPlaceholderNameDetector>() {
            @Override
            public SoapPlaceholderNameDetector call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapPlaceholderNameDetectorService(url).getSoapPlaceholderNameDetectorPort();
            }
        };
    }

}
