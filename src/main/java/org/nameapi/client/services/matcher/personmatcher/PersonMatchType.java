
package org.nameapi.client.services.matcher.personmatcher;

/**
 */
public enum PersonMatchType {

    EQUAL,
    MATCHING,
    SIMILAR,
    RELATION,
    DIFFERENT,
    ;

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
