
package org.nameapi.client.services.matcher.personmatcher.wsdl;

import org.nameapi.client.services.matcher.personmatcher.GenderMatchType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapGenderMatcherResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapGenderMatcherResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="confidence" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="matchType" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}genderMatchType" minOccurs="0"/>
 *         &lt;element name="warnings" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapGenderMatcherResult", propOrder = {
    "confidence",
    "matchType",
    "warnings"
})
public class SoapGenderMatcherResult {

    protected double confidence;
    protected GenderMatchType matchType;
    @XmlElement(nillable = true)
    protected List<String> warnings;

    /**
     * Gets the value of the confidence property.
     * 
     */
    public double getConfidence() {
        return confidence;
    }

    /**
     * Sets the value of the confidence property.
     * 
     */
    public void setConfidence(double value) {
        this.confidence = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link GenderMatchType }
     *     
     */
    public GenderMatchType getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenderMatchType }
     *     
     */
    public void setMatchType(GenderMatchType value) {
        this.matchType = value;
    }

    /**
     * Gets the value of the warnings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warnings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarnings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getWarnings() {
        if (warnings == null) {
            warnings = new ArrayList<String>();
        }
        return this.warnings;
    }

}
