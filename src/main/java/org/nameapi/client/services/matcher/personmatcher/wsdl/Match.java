
package org.nameapi.client.services.matcher.personmatcher.wsdl;

import org.nameapi.client.commonwsdl.context.SoapContext;
import org.nameapi.client.commonwsdl.person.SoapSimpleNaturalPerson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for match complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="match">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}soapContext"/>
 *         &lt;element name="person1" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}soapSimpleNaturalPerson"/>
 *         &lt;element name="person2" type="{http://personmatcher.matcher.services.v4_0.soap.server.nameapi.org/}soapSimpleNaturalPerson"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "match", propOrder = {
    "context",
    "person1",
    "person2"
})
public class Match {

    @XmlElement(required = true)
    protected SoapContext context;
    @XmlElement(required = true)
    protected SoapSimpleNaturalPerson person1;
    @XmlElement(required = true)
    protected SoapSimpleNaturalPerson person2;

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
     * Gets the value of the person1 property.
     * 
     * @return
     *     possible object is
     *     {@link SoapSimpleNaturalPerson }
     *     
     */
    public SoapSimpleNaturalPerson getPerson1() {
        return person1;
    }

    /**
     * Sets the value of the person1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapSimpleNaturalPerson }
     *     
     */
    public void setPerson1(SoapSimpleNaturalPerson value) {
        this.person1 = value;
    }

    /**
     * Gets the value of the person2 property.
     * 
     * @return
     *     possible object is
     *     {@link SoapSimpleNaturalPerson }
     *     
     */
    public SoapSimpleNaturalPerson getPerson2() {
        return person2;
    }

    /**
     * Sets the value of the person2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapSimpleNaturalPerson }
     *     
     */
    public void setPerson2(SoapSimpleNaturalPerson value) {
        this.person2 = value;
    }

}
