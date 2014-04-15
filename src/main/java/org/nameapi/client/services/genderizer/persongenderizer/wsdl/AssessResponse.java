
package org.nameapi.client.services.genderizer.persongenderizer.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for assessResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="assessResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/}soapPersonGenderizerResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assessResponse", propOrder = {
    "_return"
})
public class AssessResponse {

    @XmlElement(name = "return")
    protected SoapPersonGenderizerResult _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link SoapPersonGenderizerResult }
     *     
     */
    public SoapPersonGenderizerResult getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapPersonGenderizerResult }
     *     
     */
    public void setReturn(SoapPersonGenderizerResult value) {
        this._return = value;
    }

}
