package org.nameapi.client.services.parser.personnameparser;

/**
 * Parses the name fields of a person's name.
 */
public class PersonNameParserCommand
//        extends NameApiBaseCommand<SoapPersonNameParser, InputPerson, PersonNameParserResult>
{

//    private static final String servicePath = "/parser/personnameparser";
//
//    public PersonNameParserCommand() {
//        super(SoapPersonNameParser.class);
//    }
//
//    @Override @NotNull
//    public PersonNameParserResult call(@NotNull Optional<InputPerson> arg, @NotNull ExecutionContext ec) throws Exception {
//        SoapPersonNameParserResult result = getPort(ec).parse(getContext(ec), Conversions.convert(arg.get()));
//        return ParserConversions.convertResult(result);
//    }
//
//
//    @NotNull @Override
//    protected Callable<SoapPersonNameParser> createPort(@NotNull final ExecutionContext ec) {
//        return new Callable<SoapPersonNameParser>() {
//            @Override
//            public SoapPersonNameParser call() throws Exception {
//                URL url = makeUrl(ec, servicePath);
//                return new SoapPersonNameParserService(url).getSoapPersonNameParserPort();
//            }
//        };
//    }

}
