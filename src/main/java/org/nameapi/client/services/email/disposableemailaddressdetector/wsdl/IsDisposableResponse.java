
package org.nameapi.client.services.email.disposableemailaddressdetector.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for isDisposableResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="isDisposableResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/}soapDisposableEmailAddressDetectorResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isDisposableResponse", propOrder = {
    "_return"
})
public class IsDisposableResponse {

    @XmlElement(name = "return")
    protected SoapDisposableEmailAddressDetectorResult _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link SoapDisposableEmailAddressDetectorResult }
     *     
     */
    public SoapDisposableEmailAddressDetectorResult getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapDisposableEmailAddressDetectorResult }
     *     
     */
    public void setReturn(SoapDisposableEmailAddressDetectorResult value) {
        this._return = value;
    }

}
