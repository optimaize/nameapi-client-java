
package org.nameapi.client.services.matcher.personmatcher;

/**
 */
public enum GenderMatchType {

    EQUAL,
    POSSIBLY_EQUAL,
    POSSIBLY_DIFFERENT,
    NOT_APPLICABLE,
    DIFFERENT,
    ;

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
