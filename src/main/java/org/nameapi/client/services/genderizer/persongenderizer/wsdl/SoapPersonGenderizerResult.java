
package org.nameapi.client.services.genderizer.persongenderizer.wsdl;

import org.nameapi.ontology.input.entities.person.gender.ComputedPersonGender;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapPersonGenderizerResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapPersonGenderizerResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="confidence" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="gender" type="{http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/}computedPersonGender" minOccurs="0"/>
 *         &lt;element name="maleProportion" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapPersonGenderizerResult", propOrder = {
    "confidence",
    "gender",
    "maleProportion"
})
public class SoapPersonGenderizerResult {

    protected double confidence;
    protected ComputedPersonGender gender;
    protected Double maleProportion;

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
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link org.nameapi.ontology.input.entities.person.gender.ComputedPersonGender }
     *     
     */
    public ComputedPersonGender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.nameapi.ontology.input.entities.person.gender.ComputedPersonGender }
     *     
     */
    public void setGender(ComputedPersonGender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the maleProportion property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaleProportion() {
        return maleProportion;
    }

    /**
     * Sets the value of the maleProportion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaleProportion(Double value) {
        this.maleProportion = value;
    }

}
