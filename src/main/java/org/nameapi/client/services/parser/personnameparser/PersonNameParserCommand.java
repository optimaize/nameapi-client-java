package org.nameapi.client.services.parser.personnameparser;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.commonwsdl.Conversions;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.client.services.parser.ParserConversions;
import org.nameapi.client.services.parser.personnameparser.wsdl.SoapPersonNameParser;
import org.nameapi.client.services.parser.personnameparser.wsdl.SoapPersonNameParserResult;
import org.nameapi.client.services.parser.personnameparser.wsdl.SoapPersonNameParserService;
import org.nameapi.ontology.input.entities.person.InputPerson;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Parses the name fields of a person's name.
 */
public class PersonNameParserCommand
        extends NameApiBaseCommand<SoapPersonNameParser, InputPerson, PersonNameParserResult>
{

    private static final String servicePath = "/parser/personnameparser";

    public PersonNameParserCommand() {
        super(SoapPersonNameParser.class);
    }

    @Override @NotNull
    public PersonNameParserResult call(@NotNull Optional<InputPerson> arg, @NotNull ExecutionContext ec) throws Exception {
        SoapPersonNameParserResult result = getPort(ec).parse(getContext(ec), Conversions.convert(arg.get()));
        return ParserConversions.convertResult(result);
    }


    @NotNull @Override
    protected Callable<SoapPersonNameParser> createPort(@NotNull final ExecutionContext ec) {
        return new Callable<SoapPersonNameParser>() {
            @Override
            public SoapPersonNameParser call() throws Exception {
                URL url = makeUrl(ec, servicePath);
                return new SoapPersonNameParserService(url).getSoapPersonNameParserPort();
            }
        };
    }

}
