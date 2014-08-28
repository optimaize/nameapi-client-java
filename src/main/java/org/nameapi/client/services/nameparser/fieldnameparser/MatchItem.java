
package org.nameapi.client.services.nameparser.fieldnameparser;

import crema.annotation.Immutable;
import org.jetbrains.annotations.NotNull;
import org.nameapi.client.services.nameparser.fieldnameparser.wsdl.SoapTerm;
import org.nameapi.ontology4.output.entities.person.name.Term;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


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
