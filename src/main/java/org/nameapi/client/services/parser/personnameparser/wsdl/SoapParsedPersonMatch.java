
package org.nameapi.client.services.parser.personnameparser.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapParsedPersonMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapParsedPersonMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="confidence" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="likeliness" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="parsedPerson" type="{http://personnameparser.parser.services.v4_0.soap.server.nameapi.org/}soapParsedPerson" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapParsedPersonMatch", propOrder = {
    "confidence",
    "likeliness",
    "parsedPerson"
})
public class SoapParsedPersonMatch {

    protected double confidence;
    protected double likeliness;
    protected SoapParsedPerson parsedPerson;

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
     * Gets the value of the parsedPerson property.
     * 
     * @return
     *     possible object is
     *     {@link SoapParsedPerson }
     *     
     */
    public SoapParsedPerson getParsedPerson() {
        return parsedPerson;
    }

    /**
     * Sets the value of the parsedPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapParsedPerson }
     *     
     */
    public void setParsedPerson(SoapParsedPerson value) {
        this.parsedPerson = value;
    }

}
