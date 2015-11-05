package org.nameapi.client.services.nameparser.syntax;

/**
 * The command that parses a name string into its elements based on custom syntax rules.
 */
public class SyntaxBasedNameParserCommand
//        extends NameApiBaseCommand<SoapNameParser, NameParserArgument, NameParserResult>
{

//    private static final String servicePath = "/nameparser/syntax";
//
//    public SyntaxBasedNameParserCommand() {
//        super(SoapNameParser.class);
//    }
//
//    @Override @NotNull
//    public NameParserResult call(@NotNull Optional<NameParserArgument> arg, @NotNull ExecutionContext ec) throws Exception {
//        SoapParserResult result = getPort(ec).parse(getContext(ec), arg.get().getNameString(), arg.get().getRules());
//        return Conversion.convert(result);
//    }
//
//
//    @NotNull @Override
//    protected Callable<SoapNameParser> createPort(@NotNull final ExecutionContext ec) {
//        return new Callable<SoapNameParser>() {
//            @Override
//            public SoapNameParser call() throws Exception {
//                URL url = makeUrl(ec, servicePath);
//                return new SoapNameParserService(url).getSoapNameParserPort();
//            }
//        };
//    }

}
