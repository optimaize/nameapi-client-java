
package org.nameapi.client.services.matcher.personmatcher;

/**
 */
public enum PersonNameMatchType {

    EQUAL,

    MATCHING,

    SIMILAR,

    /**
     * @since v4.1
     */
    NO_SIMILARITY_FOUND,

    DIFFERENT,
    ;

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
