
package org.nameapi.client.services.validator.gender.genericgendervalidator;

import com.google.common.base.Optional;
import cremacopy.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 */
@Immutable
public final class GenderValidationResult {

    @NotNull
    private final Optional<Integer> confidence;
    @NotNull
    private final Optional<String> reasoning;
    @NotNull
    private final GenderValidationResultType type;
    @NotNull
    private final Optional<Integer> wrongChance;

    public GenderValidationResult(
            @Nullable Integer confidence,
            @Nullable String reasoning,
            @NotNull GenderValidationResultType type,
            @Nullable Integer wrongChance
    ) {
        this.confidence  = Optional.fromNullable(confidence);
        this.reasoning   = Optional.fromNullable(reasoning);
        this.type        = type;
        this.wrongChance = Optional.fromNullable(wrongChance);
    }


    @NotNull
    public Optional<Integer> getConfidence() {
        return confidence;
    }

    @NotNull
    public Optional<String> getReasoning() {
        return reasoning;
    }

    @NotNull
    public GenderValidationResultType getType() {
        return type;
    }

    @NotNull
    public Optional<Integer> getWrongChance() {
        return wrongChance;
    }


    @Override
    public String toString() {
        return "GenderValidationResult{" +
                "confidence=" + confidence +
                ", reasoning=" + reasoning +
                ", type=" + type +
                ", wrongChance=" + wrongChance +
                '}';
    }
}
