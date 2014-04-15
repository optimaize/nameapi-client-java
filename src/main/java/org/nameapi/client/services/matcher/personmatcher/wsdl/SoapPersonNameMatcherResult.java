
package org.nameapi.client.services.matcher.personmatcher.wsdl;

import org.nameapi.client.services.matcher.personmatcher.PersonNameMatchType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapPersonNameMatcherResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapPersonNameMatcherResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="matchType" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}personNameMatchType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapPersonNameMatcherResult", propOrder = {
    "matchType"
})
public class SoapPersonNameMatcherResult {

    protected PersonNameMatchType matchType;

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameMatchType }
     *     
     */
    public PersonNameMatchType getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameMatchType }
     *     
     */
    public void setMatchType(PersonNameMatchType value) {
        this.matchType = value;
    }

}
