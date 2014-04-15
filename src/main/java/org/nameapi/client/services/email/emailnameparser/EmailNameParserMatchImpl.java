package org.nameapi.client.services.email.emailnameparser;

import crema.annotation.Immutable;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 */
@Immutable
final class EmailNameParserMatchImpl implements EmailNameParserMatch {

    @NotNull
    private final List<NameFromEmailAddress> givenNames;
    @NotNull
    private final List<NameFromEmailAddress> surnames;

    private final double confidence;

    EmailNameParserMatchImpl(@NotNull List<NameFromEmailAddress> givenNames,
                             @NotNull List<NameFromEmailAddress> surnames,
                             double confidence) {
        this.givenNames = Collections.unmodifiableList(givenNames);
        this.surnames   = Collections.unmodifiableList(surnames);
        this.confidence = confidence;
    }

    @NotNull
    public List<NameFromEmailAddress> getGivenNames() {
        return givenNames;
    }

    @NotNull
    public List<NameFromEmailAddress> getSurnames() {
        return surnames;
    }

    public double getConfidence() {
        return confidence;
    }

    @Override
    public String toString() {
        return "EmailNameExtractingMatch{" +
                "givenNames=" + givenNames +
                ", surnames=" + surnames +
                ", confidence=" + confidence +
                '}';
    }
}
