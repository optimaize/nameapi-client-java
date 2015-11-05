package org.nameapi.client.services.nameparser.fieldnameparser;

import com.google.common.base.Optional;
import com.optimaize.command4j.ExecutionContext;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.NameApiBaseCommand;
import org.nameapi.ontology5.input.entities.person.name.NameField;
import org.nameapi.ontology5.output.entities.person.name.Term;
import org.nameapi.ontology5.output.entities.person.name.TermType;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Parses the contents of a name field into its components.
 */
public class FieldNameParserCommand
//        extends NameApiBaseCommand<SoapFieldNameParser, NameField, FieldNameParserResult>
{

//    private static final String servicePath = "/nameparser/fieldnameparser";
//
//    public FieldNameParserCommand() {
//        super(SoapFieldNameParser.class);
//    }
//
//    @Override @NotNull
//    public FieldNameParserResult call(@NotNull Optional<NameField> arg, @NotNull ExecutionContext ec) throws Exception {
//        SoapFieldNameParserResult result = getPort(ec).parse(getContext(ec), Conversions.convert(arg.get()));
//        return convert(result);
//    }
//
//    private FieldNameParserResult convert(SoapFieldNameParserResult result) {
//        if (result.getMatches().isEmpty()) {
//            return FieldNameParserResult.empty();
//        } else {
//            List<Match> matches = new ArrayList<>();
//            for (SoapMatch soapMatch : result.getMatches()) {
//                List<MatchItem> matchItems = new ArrayList<>();
//                for (SoapMatchItem soapMatchItem : soapMatch.getMatchItems()) {
//                    SoapTerm term1 = soapMatchItem.getTerm();
//                    Term term = new Term(term1.getString(), TermType.valueOf(term1.getTermType()));
//                    matchItems.add( new MatchItem(term, soapMatchItem.getLikeliness(), soapMatchItem.getConfidence()) );
//                }
//                matches.add(new Match(matchItems, soapMatch.getLikeliness()));
//            }
//            return new FieldNameParserResult(matches);
//        }
//    }
//
//
//    @NotNull @Override
//    protected Callable<SoapFieldNameParser> createPort(@NotNull final ExecutionContext ec) {
//        return new Callable<SoapFieldNameParser>() {
//            @Override
//            public SoapFieldNameParser call() throws Exception {
//                URL url = makeUrl(ec, servicePath);
//                return new SoapFieldNameParserService(url).getSoapFieldNameParserPort();
//            }
//        };
//    }

}
