
package org.nameapi.client.services.nameparser.fieldnameparser.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="likeliness" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="matchItems" type="{http://fieldnameparser.nameparser.services.v4_0.soap.server.nameapi.org/}soapMatchItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapMatch", propOrder = {
    "likeliness",
    "matchItems"
})
public class SoapMatch {

    protected double likeliness;
    @XmlElement(nillable = true)
    protected List<SoapMatchItem> matchItems;

    /**
     * Gets the value of the likeliness property.
     * 
     */
    public double getLikeliness() {
        return likeliness;
    }

    /**
     * Sets the value of the likeliness property.
     * 
     */
    public void setLikeliness(double value) {
        this.likeliness = value;
    }

    /**
     * Gets the value of the matchItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matchItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatchItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapMatchItem }
     * 
     * 
     */
    public List<SoapMatchItem> getMatchItems() {
        if (matchItems == null) {
            matchItems = new ArrayList<SoapMatchItem>();
        }
        return this.matchItems;
    }

}
