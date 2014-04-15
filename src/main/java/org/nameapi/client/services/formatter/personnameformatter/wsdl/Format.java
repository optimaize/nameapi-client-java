
package org.nameapi.client.services.formatter.personnameformatter.wsdl;

import org.nameapi.client.commonwsdl.context.SoapContext;
import org.nameapi.client.commonwsdl.person.SoapSimpleNaturalPerson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for format complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="format">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/}soapContext"/>
 *         &lt;element name="person" type="{http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/}soapSimpleNaturalPerson"/>
 *         &lt;element name="properties" type="{http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/}soapFormatterProperties"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "format", propOrder = {
    "context",
    "person",
    "properties"
})
public class Format {

    @XmlElement(required = true)
    protected SoapContext context;
    @XmlElement(required = true)
    protected SoapSimpleNaturalPerson person;
    @XmlElement(required = true)
    protected SoapFormatterProperties properties;

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link SoapContext }
     *     
     */
    public SoapContext getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapContext }
     *     
     */
    public void setContext(SoapContext value) {
        this.context = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link SoapSimpleNaturalPerson }
     *     
     */
    public SoapSimpleNaturalPerson getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapSimpleNaturalPerson }
     *     
     */
    public void setPerson(SoapSimpleNaturalPerson value) {
        this.person = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link SoapFormatterProperties }
     *     
     */
    public SoapFormatterProperties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapFormatterProperties }
     *     
     */
    public void setProperties(SoapFormatterProperties value) {
        this.properties = value;
    }

}
