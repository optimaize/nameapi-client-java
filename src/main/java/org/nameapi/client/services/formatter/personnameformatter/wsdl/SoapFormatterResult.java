
package org.nameapi.client.services.formatter.personnameformatter.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapFormatterResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapFormatterResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="formatted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unknown" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapFormatterResult", propOrder = {
    "formatted",
    "unknown"
})
public class SoapFormatterResult {

    protected String formatted;
    protected boolean unknown;

    /**
     * Gets the value of the formatted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatted() {
        return formatted;
    }

    /**
     * Sets the value of the formatted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatted(String value) {
        this.formatted = value;
    }

    /**
     * Gets the value of the unknown property.
     * 
     */
    public boolean isUnknown() {
        return unknown;
    }

    /**
     * Sets the value of the unknown property.
     * 
     */
    public void setUnknown(boolean value) {
        this.unknown = value;
    }

}
