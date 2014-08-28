package org.nameapi.client.services.validator.famouspersondetector;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.validator.famouspersondetector.wsdl.SoapFamousPersonDetector;
import org.nameapi.client.services.validator.famouspersondetector.wsdl.SoapFamousPersonDetectorService;
import org.nameapi.client.services.validator.famouspersondetector.wsdl.SoapFamousPersonResult;
import org.nameapi.ontology4.input.entities.person.InputPerson;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Tells if and how famous a person's name is.
 *
 * <p>The classification is done with a global view, not specific to the context's place.</p>
 *
 * <p>Returns zero points for names that are not known to be famous.
 * Returns <code>null</code> when no name input is given, or when for some other reason no result
 * can be returned (very unlikely). You may treat null the same as zero points.</p>
 */
public class FamousPersonDetectorCommand
        extends NameApiBaseCommand<SoapFamousPersonDetector, InputPerson, FamousPersonResult>
{

    private static final String servicePath = "/validator/famouspersondetector";

    public FamousPersonDetectorCommand() {
        super(SoapFamousPersonDetector.class);
    }

    @Override @Nullable
    public FamousPersonResult call(@NotNull Optional<InputPerson> arg, @NotNull ExecutionContext ec) throws Exception {
        SoapFamousPersonResult result = getPort(ec).checkPerson(getContext(ec), Conversions.convert(arg.get()));
        if (result==null) return null;
        return convert(result);
    }

    @NotNull
    private FamousPersonResult convert(@NotNull SoapFamousPersonResult result) {
        return new FamousPersonResult(
                result.getPoints(),
                result.getMessage()
        );
    }


    @NotNull @Override
    protected Callable<SoapFamousPersonDetector> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapFamousPersonDetector>() {
            @Override
            public SoapFamousPersonDetector call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapFamousPersonDetectorService(url).getSoapFamousPersonDetectorPort();
            }
        };
    }

}
