package org.nameapi.client.services.email.emailnameparser;

/**
 * What kind of name string it is.
 */
public enum EmailAddressNameType {

    /**
     * It's a regular name, like "Peter" or "Johnson".
     */
    NAME,

    /**
     * It's an abbreviated name with an initial like "P".
     * The string does not end with a dot.
     */
    INITIAL;


    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }

}
