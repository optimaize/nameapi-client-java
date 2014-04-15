
package org.nameapi.client.services.matcher.personmatcher.wsdl;

import org.nameapi.client.services.matcher.personmatcher.AgeMatchType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapAgeMatcherResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapAgeMatcherResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="matchType" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}ageMatchType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapAgeMatcherResult", propOrder = {
    "matchType"
})
public class SoapAgeMatcherResult {

    protected AgeMatchType matchType;

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link AgeMatchType }
     *     
     */
    public AgeMatchType getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgeMatchType }
     *     
     */
    public void setMatchType(AgeMatchType value) {
        this.matchType = value;
    }

}
