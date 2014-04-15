package org.nameapi.client.services.email.emailnameparser;


/**
 * Belongs to {@link EmailNameParserResult}, tells what was detected.
 */
public enum EmailAddressParsingResultType {

    /**
     * The email address belongs to a department, such as accounting@example.com.
     */
    DEPARTMENT,

    /**
     * It is a technical email address for the domain, such as hostmaster@example.com.
     *
     */
    TECHNICAL,

    /**
     * The email address contains a person's initials such as ab@example.com.
     * <p>Note that this answer is a guess, the 2 letters could also have another meaning
     * such as a short given name or surname, or something completely different.</p>
     */
    INITIALS,

    /**
     * The email address contains a person's name such as john.doe@example.com.
     */
    PERSON_NAME,

    /**
     * There is no name in the address, for example x2000@example.com
     * <p>The address may be personal or non-personal, can't say (as in UNKNOWN)
     * but it is clear that no name can be found in it.</p>
     */
    NOT_A_NAME,

    /**
     * The email address could not be classified and hence the service failed to extract a name.
     */
    UNKNOWN;

    public boolean isUnknown() {
        return this == UNKNOWN;
    }


    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code calling this with "+size+"!";
    }

}
