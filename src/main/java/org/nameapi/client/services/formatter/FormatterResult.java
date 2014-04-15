package org.nameapi.client.services.formatter;

import org.jetbrains.annotations.NotNull;

/**
 * @author Fabian Kessler
 */
public interface FormatterResult {

    /**
     * @return the nicely formatted string, possibly the same as the input.
     */
    @NotNull
    String getFormatted();

    /**
     * @return if <code>true</code> then server didn't understand the input, but still tried to format it.
     * This feature must be enabled specifically in the input properties.
     */
    boolean isUnknown();

}
