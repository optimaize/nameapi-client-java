
package org.nameapi.client.services.matcher.personmatcher;

/**
 *
 */
public class PersonNameMatcherResult {

    private final PersonNameMatchType matchType;

    public PersonNameMatcherResult(PersonNameMatchType matchType) {
        this.matchType = matchType;
    }

    public PersonNameMatchType getMatchType() {
        return matchType;
    }
}
