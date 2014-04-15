package org.nameapi.client.services.matcher.personmatcher;

/**
 */
public class AgeMatcherResult {

    private final AgeMatchType matchType;

    public AgeMatcherResult(AgeMatchType matchType) {
        this.matchType = matchType;
    }

    public AgeMatchType getMatchType() {
        return matchType;
    }
}
