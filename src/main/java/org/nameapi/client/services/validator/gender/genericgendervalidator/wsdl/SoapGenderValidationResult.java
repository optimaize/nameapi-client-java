
package org.nameapi.client.services.validator.gender.genericgendervalidator.wsdl;

import org.nameapi.client.services.validator.gender.genericgendervalidator.GenderValidationResultType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapGenderValidationResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapGenderValidationResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="confidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="reasoning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://genericgendervalidator.gender.validator.services.v4_0.soap.server.nameapi.org/}genderValidationResultType" minOccurs="0"/>
 *         &lt;element name="wrongChance" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapGenderValidationResult", propOrder = {
    "confidence",
    "reasoning",
    "type",
    "wrongChance"
})
public class SoapGenderValidationResult {

    protected Integer confidence;
    protected String reasoning;
    protected GenderValidationResultType type;
    protected Integer wrongChance;

    /**
     * Gets the value of the confidence property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getConfidence() {
        return confidence;
    }

    /**
     * Sets the value of the confidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setConfidence(Integer value) {
        this.confidence = value;
    }

    /**
     * Gets the value of the reasoning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasoning() {
        return reasoning;
    }

    /**
     * Sets the value of the reasoning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasoning(String value) {
        this.reasoning = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link GenderValidationResultType }
     *     
     */
    public GenderValidationResultType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenderValidationResultType }
     *     
     */
    public void setType(GenderValidationResultType value) {
        this.type = value;
    }

    /**
     * Gets the value of the wrongChance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWrongChance() {
        return wrongChance;
    }

    /**
     * Sets the value of the wrongChance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWrongChance(Integer value) {
        this.wrongChance = value;
    }

}
