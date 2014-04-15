package org.nameapi.client.services.formatter.personnameformatter;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.formatter.FormatterResult;
import org.nameapi.client.services.formatter.FormatterResultImpl;
import org.nameapi.client.services.formatter.personnameformatter.wsdl.SoapFormatterProperties;
import org.nameapi.client.services.formatter.personnameformatter.wsdl.SoapFormatterResult;
import org.nameapi.client.services.formatter.personnameformatter.wsdl.SoapPersonNameFormatter;
import org.nameapi.client.services.formatter.personnameformatter.wsdl.SoapPersonNameFormatterService;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Service for formatting person names.
 *
 * <p>Example: "jean-claude von bergen-meyer" => "Jean-Claude von Bergen-Meyer"</p>
 */
public class PersonNameFormatterCommand
        extends NameApiBaseCommand<SoapPersonNameFormatter, PersonNameFormatterArgument, FormatterResult>
{

    private static final String servicePath = "/formatter/personnameformatter";

    public PersonNameFormatterCommand() {
        super(SoapPersonNameFormatter.class);
    }

    @Override @NotNull
    public FormatterResult call(@NotNull Optional<PersonNameFormatterArgument> arg, @NotNull ExecutionContext ec) throws Exception {
        PersonNameFormatterArgument argument = arg.get();

        SoapFormatterProperties soapFormatterProperties = new SoapFormatterProperties();
        soapFormatterProperties.setCaseChoice(argument.getFormatterProperties().getCaseChoice());
        soapFormatterProperties.setNameOrderChoice(argument.getFormatterProperties().getNameOrderChoice());

        SoapFormatterResult result = getPort(ec).format(
                getContext(ec),
                Conversions.convert(argument.getInputPerson()),
                soapFormatterProperties
        );
        return convert(result);
    }

    private FormatterResult convert(SoapFormatterResult result) {
        return new FormatterResultImpl(result.getFormatted(), result.isUnknown());
    }

    @NotNull @Override
    protected Callable<SoapPersonNameFormatter> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapPersonNameFormatter>() {
            @Override
            public SoapPersonNameFormatter call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapPersonNameFormatterService(url).getSoapPersonNameFormatterPort();
            }
        };
    }

}
