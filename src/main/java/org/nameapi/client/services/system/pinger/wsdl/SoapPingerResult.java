
package org.nameapi.client.services.system.pinger.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapPingerResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapPingerResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pong" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapPingerResult", propOrder = {
    "pong"
})
public class SoapPingerResult {

    protected String pong;

    /**
     * Gets the value of the pong property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPong() {
        return pong;
    }

    /**
     * Sets the value of the pong property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPong(String value) {
        this.pong = value;
    }

}
