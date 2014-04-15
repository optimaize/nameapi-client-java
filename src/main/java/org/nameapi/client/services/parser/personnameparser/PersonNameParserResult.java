package org.nameapi.client.services.parser.personnameparser;

import java.util.List;

/**
 */
public class PersonNameParserResult {

    private final List<ParsedPersonMatch> matches;

    public PersonNameParserResult(List<ParsedPersonMatch> matches) {
        if (matches.isEmpty()) throw new IllegalArgumentException("At least one match is required!");
        this.matches = matches;
    }

    /**
     * @return not empty.
     */
    public List<ParsedPersonMatch> getMatches() {
        return matches;
    }

    public ParsedPersonMatch getBestMatch() {
        return matches.get(0);
    }

}
