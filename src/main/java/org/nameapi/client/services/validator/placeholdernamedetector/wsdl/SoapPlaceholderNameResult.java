
package org.nameapi.client.services.validator.placeholdernamedetector.wsdl;

import org.nameapi.client.services.validator.placeholdernamedetector.FakeType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapPlaceholderNameResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapPlaceholderNameResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fakeType" type="{http://placeholdernamedetector.validator.services.v4_0.soap.server.nameapi.org/}fakeType" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="points" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapPlaceholderNameResult", propOrder = {
    "fakeType",
    "message",
    "points"
})
public class SoapPlaceholderNameResult {

    protected FakeType fakeType;
    protected String message;
    protected int points;

    /**
     * Gets the value of the fakeType property.
     * 
     * @return
     *     possible object is
     *     {@link FakeType }
     *     
     */
    public FakeType getFakeType() {
        return fakeType;
    }

    /**
     * Sets the value of the fakeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FakeType }
     *     
     */
    public void setFakeType(FakeType value) {
        this.fakeType = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the points property.
     * 
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the value of the points property.
     * 
     */
    public void setPoints(int value) {
        this.points = value;
    }

}
