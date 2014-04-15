
package org.nameapi.client.services.validator.placeholdernamedetector;

/**
 */
public enum FakeType {

    RANDOM_TYPING,
    PLACEHOLDER_NAME,
    FICTIONAL_NAME,
    FAMOUS_NAME,
    HUMEROUS_NAME,
    NOT_A_NAME,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static FakeType fromValue(String v) {
        return valueOf(v);
    }

}
