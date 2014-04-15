package org.nameapi.client.services.genderizer;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.ontology.input.entities.person.gender.ComputedPersonGender;

/**
 */
public final class PersonGenderizerResult {

    @NotNull
    private final ComputedPersonGender gender;

    /**
     * If neutral (otherwise <code>absent</code>) then this may be specified (but does not have to be),
     * 0-1, the remaining % are for female.
     */
    @NotNull
    private final Optional<Double> maleProportion;

    /**
     * 0-1 where 1 is the best.
     */
    private final double confidence;

    public PersonGenderizerResult(@NotNull ComputedPersonGender gender, @Nullable Double maleProportion, double confidence) {
        this.gender = gender;
        this.maleProportion = Optional.fromNullable(maleProportion);
        this.confidence = confidence;
    }


    @NotNull
    public ComputedPersonGender getGender() {
        return gender;
    }

    @NotNull
    public Optional<Double> getMaleProportion() {
        return maleProportion;
    }

    public double getConfidence() {
        return confidence;
    }


    @Override
    public String toString() {
        String ret = "GenderResult{" +
                "gender=" + gender;
        if (!gender.isClear() && gender.hasGenderInfo() && maleProportion.isPresent()) {
            ret += ", maleProportion=" + maleProportion;
        }
        ret += ", confidence=" + confidence +'}';
        return ret;
    }
}
