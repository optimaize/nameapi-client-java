
package org.nameapi.client.services.email.emailnameparser2;

/**
 * Belongs to {@link org.nameapi.client.services.email.emailnameparser2.EmailNameParserResult}, tells what was detected.
 *
 * Difference to the EmailAddressParsingResultType:
 * The enum uses FUNCTIONAL instead of DEPARTMENT and TECHNICAL because the two can hardly be told apart.
 */
public enum EmailAddressParsingResultType2 {

    /**
     * The email address belongs to a department (eg accounting@example.com) or is
     * technical (eg hostmaster@example.com).
     */
    FUNCTIONAL,

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
