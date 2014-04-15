
package org.nameapi.client.services.validator.placeholdernamedetector.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkPersonResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkPersonResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://placeholdernamedetector.validator.services.v4_0.soap.server.nameapi.org/}soapPlaceholderNameResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkPersonResponse", propOrder = {
    "_return"
})
public class CheckPersonResponse {

    @XmlElement(name = "return")
    protected SoapPlaceholderNameResult _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link SoapPlaceholderNameResult }
     *     
     */
    public SoapPlaceholderNameResult getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapPlaceholderNameResult }
     *     
     */
    public void setReturn(SoapPlaceholderNameResult value) {
        this._return = value;
    }

}
