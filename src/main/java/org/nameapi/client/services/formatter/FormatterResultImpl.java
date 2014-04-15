package org.nameapi.client.services.formatter;

import org.jetbrains.annotations.NotNull;

/**
 */
public final class FormatterResultImpl implements FormatterResult {

    @NotNull
    private final String formatted;

    private final boolean unknown;


    public FormatterResultImpl(@NotNull String formatted, boolean unknown) {
        this.formatted = formatted;
        this.unknown   = unknown;
    }


    @Override @NotNull
    public String getFormatted() {
        return formatted;
    }

    @Override
    public boolean isUnknown() {
        return unknown;
    }


    @Override
    public String toString() {
        return "CaseFormatterResult{" +
                "formatted='" + formatted + '\'' +
                ", unknown=" + unknown +
                '}';
    }
}
