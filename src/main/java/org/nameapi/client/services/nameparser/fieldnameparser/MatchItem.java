
package org.nameapi.client.services.nameparser.fieldnameparser;

import cremacopy.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.nameapi.ontology5.output.entities.person.name.Term;


/**
 *
 */
@Immutable
public class MatchItem {

    @NotNull
    private final Term term;
    private final double likeliness;
    private final double confidence;

    public MatchItem(@NotNull Term term, double likeliness, double confidence) {
        this.term = term;
        this.likeliness = likeliness;
        this.confidence = confidence;
    }

    /**
     */
    @NotNull
    public Term getTerm() {
        return term;
    }

    /**
     * @return 0-1
     */
    public double getLikeliness() {
        return likeliness;
    }

    /**
     * @return 0-1
     */
    public double getConfidence() {
        return confidence;
    }

}
