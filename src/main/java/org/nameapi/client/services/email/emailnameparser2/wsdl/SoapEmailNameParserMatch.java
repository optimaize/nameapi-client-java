
package org.nameapi.client.services.email.emailnameparser2.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapEmailNameParserMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapEmailNameParserMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="confidence" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="givenNames" type="{http://emailnameparser2.email.services.v4_0.soap.server.nameapi.org/}soapNameFromEmailAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="middleNames" type="{http://emailnameparser2.email.services.v4_0.soap.server.nameapi.org/}soapNameFromEmailAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="surnames" type="{http://emailnameparser2.email.services.v4_0.soap.server.nameapi.org/}soapNameFromEmailAddress" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapEmailNameParserMatch", propOrder = {
    "confidence",
    "givenNames",
    "middleNames",
    "surnames"
})
public class SoapEmailNameParserMatch {

    protected double confidence;
    @XmlElement(nillable = true)
    protected List<SoapNameFromEmailAddress> givenNames;
    @XmlElement(nillable = true)
    protected List<SoapNameFromEmailAddress> middleNames;
    @XmlElement(nillable = true)
    protected List<SoapNameFromEmailAddress> surnames;

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
     * Gets the value of the givenNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the givenNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGivenNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapNameFromEmailAddress }
     * 
     * 
     */
    public List<SoapNameFromEmailAddress> getGivenNames() {
        if (givenNames == null) {
            givenNames = new ArrayList<SoapNameFromEmailAddress>();
        }
        return this.givenNames;
    }

    /**
     * Gets the value of the middleNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the middleNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMiddleNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapNameFromEmailAddress }
     * 
     * 
     */
    public List<SoapNameFromEmailAddress> getMiddleNames() {
        if (middleNames == null) {
            middleNames = new ArrayList<SoapNameFromEmailAddress>();
        }
        return this.middleNames;
    }

    /**
     * Gets the value of the surnames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surnames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurnames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapNameFromEmailAddress }
     * 
     * 
     */
    public List<SoapNameFromEmailAddress> getSurnames() {
        if (surnames == null) {
            surnames = new ArrayList<SoapNameFromEmailAddress>();
        }
        return this.surnames;
    }

}
