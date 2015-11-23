package org.nameapi.client.services.development.exceptionthrower;

/**
 * Types that the server throws.
 */
public enum ExceptionType {
    InvalidInput,

    AccessDeniedNoSuchAccount,
//    AccessDeniedRequestLimitExceeded,
//    AccessDeniedTooManyConcurrentRequests,

    InternalServerError,
    ;

    /**
     * Developer: Call this before doing a switch on an enum value.
     */
    public static void assertSize(int size) {
        assert values().length == size : "Update the code calling this with "+size+"!";
    }

}
