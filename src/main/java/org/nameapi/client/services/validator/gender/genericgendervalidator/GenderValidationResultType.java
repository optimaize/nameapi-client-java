
package org.nameapi.client.services.validator.gender.genericgendervalidator;


/**
 */
public enum GenderValidationResultType {

    NOTHING_TO_VALIDATE,
    CANNOT_VALIDATE,
    CORRECT,
    POSSIBLY_CORRECT,
    POSSIBLY_WRONG,
    WRONG;

    public String value() {
        return name();
    }

    public static GenderValidationResultType fromValue(String v) {
        return valueOf(v);
    }

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }
}
