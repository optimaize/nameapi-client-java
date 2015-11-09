package org.nameapi.client.services.development.exceptionthrower;

/**
 *
 */
public class ExceptionThrowerParams {

    public enum ExceptionType {
        NotAuthorized,
        Forbidden,
        BadRequest,
        InternalServerError
    }

    public static class Builder {
        private ExceptionType exceptionType;
        private int exceptionChance = 100;

        public Builder exceptionType(ExceptionType exceptionType) {
            this.exceptionType = exceptionType;
            return this;
        }

        /**
         * @param exceptionChance 0-100, default is 100 and means always throw.
         */
        public Builder exceptionChance(int exceptionChance) {
            checkNumber(exceptionChance);
            this.exceptionChance = exceptionChance;
            return this;
        }

        public ExceptionThrowerParams build() {
            if (exceptionType==null) throw new IllegalStateException("Exception type not specified!");
            return new ExceptionThrowerParams(exceptionType, exceptionChance);
        }
    }


    private final ExceptionType exceptionType;
    private final int exceptionChance;

    /**
     * @param exceptionChance 0-100, default is 100 and means always throw.
     */
    public ExceptionThrowerParams(ExceptionType exceptionType, int exceptionChance) {
        checkNumber(exceptionChance);
        this.exceptionType = exceptionType;
        this.exceptionChance = exceptionChance;
    }

    private static void checkNumber(int exceptionChance) {
        if (exceptionChance < 0 || exceptionChance > 100) {
            throw new IllegalArgumentException("Chance must be 0-100 but was: "+exceptionChance);
        }
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public int getExceptionChance() {
        return exceptionChance;
    }
}
