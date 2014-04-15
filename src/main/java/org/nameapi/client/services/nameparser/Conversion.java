package org.nameapi.client.services.nameparser;

import org.nameapi.client.services.nameparser.syntax.NameParserRule;
import org.nameapi.client.services.nameparser.wsdl.SoapMatch;
import org.nameapi.client.services.nameparser.wsdl.SoapNameParserRule;
import org.nameapi.client.services.nameparser.wsdl.SoapParserResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts between auto-generated soap classes and nice handmade classes for the developer.
 */
public class Conversion {

    public static SoapNameParserRule convert(NameParserRule nameParserRule) {
        SoapNameParserRule soap = new SoapNameParserRule();
        soap.setName(nameParserRule.getName());
        soap.setChance(nameParserRule.getChance());
        soap.setRuleString(nameParserRule.getSyntax());
        return soap;
    }

    public static List<SoapNameParserRule> convertRules(List<NameParserRule> rules) {
        List<SoapNameParserRule> soap = new ArrayList<>();
        for (NameParserRule rule : rules) {
            soap.add(convert(rule));
        }
        return soap;
    }

    public static NameParserResult convert(SoapParserResult result) {
        return new NameParserResult(
                result.getBestMatch(),
                result.getMatches(),
                result.getShortestItemCount()
        );
    }

    public static List<Match> convertMatches(List<SoapMatch> soapMatches) {
        List<Match> ret = new ArrayList<>();
        for (SoapMatch match : soapMatches) {
            ret.add(convert(match));
        }
        return ret;
    }

    public static Match convert(SoapMatch soapMatch) {
        if (soapMatch==null) return null;
        return new Match(
                soapMatch.getCertainty(),
                soapMatch.getCulture(),
                soapMatch.getItemCount(),
                soapMatch.getItemsAsStrings(),
                soapMatch.getRuleChance(),
                soapMatch.getRuleName()
        );
    }

}
