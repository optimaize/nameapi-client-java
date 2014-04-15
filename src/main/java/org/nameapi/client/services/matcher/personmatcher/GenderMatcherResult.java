
package org.nameapi.client.services.matcher.personmatcher;

import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 *
 */
public class GenderMatcherResult {

    @NotNull
    private final GenderMatchType matchType;
    private final double confidence;
    @NotNull
    private final List<String> warnings;

    public GenderMatcherResult(@NotNull GenderMatchType matchType, double confidence, @NotNull List<String> warnings) {
        this.matchType = matchType;
        this.confidence = confidence;
        this.warnings = warnings;
    }

    @NotNull
    public GenderMatchType getMatchType() {
        return matchType;
    }

    public double getConfidence() {
        return confidence;
    }

    @NotNull
    public List<String> getWarnings() {
        return warnings;
    }

}
