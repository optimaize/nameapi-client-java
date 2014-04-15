
package org.nameapi.client.services.nameparser.fieldnameparser.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapMatchItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapMatchItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="confidence" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="likeliness" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="term" type="{http://fieldnameparser.nameparser.services.v4_0.soap.server.nameapi.org/}soapTerm" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapMatchItem", propOrder = {
    "confidence",
    "likeliness",
    "term"
})
public class SoapMatchItem {

    protected double confidence;
    protected double likeliness;
    protected SoapTerm term;

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
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link SoapTerm }
     *     
     */
    public SoapTerm getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapTerm }
     *     
     */
    public void setTerm(SoapTerm value) {
        this.term = value;
    }

}
