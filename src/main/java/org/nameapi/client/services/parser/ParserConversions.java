package org.nameapi.client.services.parser;

import org.nameapi.client.services.nameparser.fieldnameparser.wsdl.SoapTerm;
import org.nameapi.client.services.parser.personnameparser.ParsedPerson;
import org.nameapi.client.services.parser.personnameparser.ParsedPersonMatch;
import org.nameapi.client.services.parser.personnameparser.PersonNameParserResult;
import org.nameapi.client.services.parser.personnameparser.wsdl.SoapOutputPersonName;
import org.nameapi.client.services.parser.personnameparser.wsdl.SoapParsedPerson;
import org.nameapi.client.services.parser.personnameparser.wsdl.SoapParsedPersonMatch;
import org.nameapi.client.services.parser.personnameparser.wsdl.SoapPersonNameParserResult;
import org.nameapi.ontology4.output.entities.person.name.OutputPersonName;
import org.nameapi.ontology4.output.entities.person.name.OutputPersonNameImpl;
import org.nameapi.ontology4.output.entities.person.name.Term;
import org.nameapi.ontology4.output.entities.person.name.TermType;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class ParserConversions {


    public static PersonNameParserResult convertResult(SoapPersonNameParserResult result) {
        return new PersonNameParserResult(convertMatches(result.getParsedPersonMatches()));
    }

    public static List<ParsedPersonMatch> convertMatches(List<SoapParsedPersonMatch> matches) {
        List<ParsedPersonMatch> ret = new ArrayList<>(matches.size());
        for (SoapParsedPersonMatch match : matches) {
            ret.add(new ParsedPersonMatch(convertPerson(match.getParsedPerson()), match.getLikeliness(), match.getConfidence()));
        }
        return ret;
    }

    public static ParsedPerson convertPerson(SoapParsedPerson parsedPerson) {
        List<OutputPersonName> names = new ArrayList<>( parsedPerson.getNames().size() );
        for (SoapOutputPersonName name : parsedPerson.getNames()) {
            names.add(convertName(name));
        }
        return new ParsedPerson(parsedPerson.getPersonType(), names);
    }

    private static OutputPersonName convertName(SoapOutputPersonName name) {
        List<Term> terms = new ArrayList<>(name.getTerms().size());
        for (SoapTerm soapTerm : name.getTerms()) {
            terms.add( convertTerm(soapTerm) );
        }
        return new OutputPersonNameImpl(terms);
    }

    private static Term convertTerm(SoapTerm soapTerm) {
        return new Term(soapTerm.getString(), TermType.valueOf(soapTerm.getTermType()));
    }

}
