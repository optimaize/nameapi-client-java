
package org.nameapi.client.services.matcher.personmatcher;

/**
 *
 */
public enum PersonMatchComposition {

    FULL,
    PARTIAL,
    INTERSECTION,
    NOT_APPLICABLE,
    ;

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
