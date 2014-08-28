package crema.lang;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * COPY-PASTED ON 2014-08-28 FROM CREMA-LANG
 *
 *
 *
 *
 *
 *
 *
 *
 * Equivalent to a nullable Boolean where true=YES, false=NO, null=UNKNOWN.
 * With the advantage of being null-safe.
 *
 * @author fab
 */
@SuppressWarnings({"JavaDoc"})
public enum Maybe {

    /*
     * DO NOT MODIFY/RENAME THESE VALUES!
     * They are used in far too many places, for example stored as strings in databases.
     */

    UNKNOWN,
    NO,
    YES;

    /**
     * Tells if it's a clear YES.
     */
    public boolean isCertain() {
        return this == YES;
    }

    /**
     * Tells if it's a clear NO.
     */
    public boolean isNot() {
        return this == NO;
    }

    /**
     * Tells if it's not a clear NO.
     */
    public boolean couldBe() {
        return this != NO;
    }
    
    /**
     * Performs the obvious conversion:
     * <pre>
     * YES     = true
     * NO      = false
     * UNKNOWN = null
     * </pre>
     * @see #fromBoolean
     */
    @Nullable
    public Boolean toBoolean() {
        if (this==YES) return true;
        if (this==NO) return false;
        assert this==UNKNOWN;
        return null;
    }

    /**
     * Performs the obvious conversion:
     * <pre>
     * YES     = true
     * NO      = false
     * UNKNOWN = null
     * </pre>
     * @see #toBoolean()
     */
    @NotNull
    public static Maybe fromBoolean(@Nullable Boolean value) {
        if (value==null) return UNKNOWN;
        return (value) ? YES : NO;
    }

    public static Maybe getDefault() {
        return UNKNOWN;
    }
    public boolean isDefault() {
        return this == getDefault();
    }
    public boolean isUnknown() {
        return this == UNKNOWN;
    }
}
