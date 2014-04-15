
package org.nameapi.client.services.matcher.personmatcher.wsdl;

import org.nameapi.client.services.matcher.personmatcher.PersonMatchComposition;
import org.nameapi.client.services.matcher.personmatcher.PersonMatchType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapPersonMatcherResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapPersonMatcherResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ageMatcherResult" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}soapAgeMatcherResult" minOccurs="0"/>
 *         &lt;element name="confidence" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="genderMatcherResult" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}soapGenderMatcherResult" minOccurs="0"/>
 *         &lt;element name="matchComposition" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}personMatchComposition" minOccurs="0"/>
 *         &lt;element name="matchType" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}personMatchType" minOccurs="0"/>
 *         &lt;element name="personNameMatcherResult" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}soapPersonNameMatcherResult" minOccurs="0"/>
 *         &lt;element name="points" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapPersonMatcherResult", propOrder = {
    "ageMatcherResult",
    "confidence",
    "genderMatcherResult",
    "matchComposition",
    "matchType",
    "personNameMatcherResult",
    "points"
})
public class SoapPersonMatcherResult {

    protected SoapAgeMatcherResult ageMatcherResult;
    protected double confidence;
    protected SoapGenderMatcherResult genderMatcherResult;
    protected PersonMatchComposition matchComposition;
    protected PersonMatchType matchType;
    protected SoapPersonNameMatcherResult personNameMatcherResult;
    protected double points;

    /**
     * Gets the value of the ageMatcherResult property.
     * 
     * @return
     *     possible object is
     *     {@link SoapAgeMatcherResult }
     *     
     */
    public SoapAgeMatcherResult getAgeMatcherResult() {
        return ageMatcherResult;
    }

    /**
     * Sets the value of the ageMatcherResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapAgeMatcherResult }
     *     
     */
    public void setAgeMatcherResult(SoapAgeMatcherResult value) {
        this.ageMatcherResult = value;
    }

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
     * Gets the value of the genderMatcherResult property.
     * 
     * @return
     *     possible object is
     *     {@link SoapGenderMatcherResult }
     *     
     */
    public SoapGenderMatcherResult getGenderMatcherResult() {
        return genderMatcherResult;
    }

    /**
     * Sets the value of the genderMatcherResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapGenderMatcherResult }
     *     
     */
    public void setGenderMatcherResult(SoapGenderMatcherResult value) {
        this.genderMatcherResult = value;
    }

    /**
     * Gets the value of the matchComposition property.
     * 
     * @return
     *     possible object is
     *     {@link PersonMatchComposition }
     *     
     */
    public PersonMatchComposition getMatchComposition() {
        return matchComposition;
    }

    /**
     * Sets the value of the matchComposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonMatchComposition }
     *     
     */
    public void setMatchComposition(PersonMatchComposition value) {
        this.matchComposition = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link PersonMatchType }
     *     
     */
    public PersonMatchType getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonMatchType }
     *     
     */
    public void setMatchType(PersonMatchType value) {
        this.matchType = value;
    }

    /**
     * Gets the value of the personNameMatcherResult property.
     * 
     * @return
     *     possible object is
     *     {@link SoapPersonNameMatcherResult }
     *     
     */
    public SoapPersonNameMatcherResult getPersonNameMatcherResult() {
        return personNameMatcherResult;
    }

    /**
     * Sets the value of the personNameMatcherResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapPersonNameMatcherResult }
     *     
     */
    public void setPersonNameMatcherResult(SoapPersonNameMatcherResult value) {
        this.personNameMatcherResult = value;
    }

    /**
     * Gets the value of the points property.
     * 
     */
    public double getPoints() {
        return points;
    }

    /**
     * Sets the value of the points property.
     * 
     */
    public void setPoints(double value) {
        this.points = value;
    }

}
