
package org.nameapi.client.services.validator.randomtyping.givennamerandomtypingdetector.wsdl;

import org.nameapi.client.commonwsdl.context.SoapContext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkField complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkField">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/}soapSimpleContext"/>
 *         &lt;element name="term" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkField", propOrder = {
    "context",
    "term"
})
public class CheckField {

    @XmlElement(required = true)
    protected SoapContext context;
    @XmlElement(required = true)
    protected String term;

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link org.nameapi.client.commonwsdl.context.SoapContext }
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
     *     {@link org.nameapi.client.commonwsdl.context.SoapContext }
     *     
     */
    public void setContext(SoapContext value) {
        this.context = value;
    }

    /**
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerm(String value) {
        this.term = value;
    }

}
