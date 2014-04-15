
package org.nameapi.client.services.nameparser.fieldnameparser;

import com.google.common.collect.ImmutableList;
import crema.annotation.Immutable;
import org.nameapi.client.services.nameparser.fieldnameparser.wsdl.SoapMatchItem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 */
@Immutable
public class Match {

    private final List<MatchItem> matchItems;
    private final double likeliness;

    public Match(List<MatchItem> matchItems, double likeliness) {
        this.matchItems = ImmutableList.copyOf(matchItems);
        this.likeliness = likeliness;
    }

    /**
     */
    public List<MatchItem> getMatchItems() {
        return matchItems;
    }

    /**
     * @return 0-1
     */
    public double getLikeliness() {
        return likeliness;
    }

}
