
package org.nameapi.client.services.email.disposableemailaddressdetector.wsdl;

import crema.lang.Maybe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapDisposableEmailAddressDetectorResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapDisposableEmailAddressDetectorResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="disposable" type="{http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/}maybe" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapDisposableEmailAddressDetectorResult", propOrder = {
    "disposable"
})
public class SoapDisposableEmailAddressDetectorResult {

    protected Maybe disposable;

    /**
     * Gets the value of the disposable property.
     * 
     * @return
     *     possible object is
     *     {@link crema.lang.Maybe }
     *     
     */
    public Maybe getDisposable() {
        return disposable;
    }

    /**
     * Sets the value of the disposable property.
     * 
     * @param value
     *     allowed object is
     *     {@link crema.lang.Maybe }
     *     
     */
    public void setDisposable(Maybe value) {
        this.disposable = value;
    }

}
