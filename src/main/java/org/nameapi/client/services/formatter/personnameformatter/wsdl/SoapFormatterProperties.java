
package org.nameapi.client.services.formatter.personnameformatter.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapFormatterProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapFormatterProperties">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caseChoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nameOrderChoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapFormatterProperties", propOrder = {
    "caseChoice",
    "nameOrderChoice"
})
public class SoapFormatterProperties {

    protected String caseChoice;
    protected String nameOrderChoice;

    /**
     * Gets the value of the caseChoice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseChoice() {
        return caseChoice;
    }

    /**
     * Sets the value of the caseChoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseChoice(String value) {
        this.caseChoice = value;
    }

    /**
     * Gets the value of the nameOrderChoice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOrderChoice() {
        return nameOrderChoice;
    }

    /**
     * Sets the value of the nameOrderChoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOrderChoice(String value) {
        this.nameOrderChoice = value;
    }

}
