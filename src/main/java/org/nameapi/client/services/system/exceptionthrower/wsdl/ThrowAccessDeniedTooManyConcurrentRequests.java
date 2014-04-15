
package org.nameapi.client.services.system.exceptionthrower.wsdl;

import org.nameapi.client.commonwsdl.context.SoapContext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for throwAccessDeniedTooManyConcurrentRequests complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="throwAccessDeniedTooManyConcurrentRequests">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://exceptionthrower.system.services.v4_0.soap.server.nameapi.org/}soapContext"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "throwAccessDeniedTooManyConcurrentRequests", propOrder = {
    "context"
})
public class ThrowAccessDeniedTooManyConcurrentRequests {

    @XmlElement(required = true)
    protected SoapContext context;

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

}
