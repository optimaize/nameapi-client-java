
package org.nameapi.client.commonwsdl.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for faultBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="faultBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blame" type="{http://ping.system.services.v4_0.soap.server.nameapi.org/}blame" minOccurs="0"/>
 *         &lt;element name="problemLogged" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="retry" type="{http://ping.system.services.v4_0.soap.server.nameapi.org/}retry" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faultBean", propOrder = {
    "blame",
    "problemLogged",
    "retry"
})
public class FaultBean {

    protected Blame blame;
    protected boolean problemLogged;
    protected Retry retry;

    /**
     * Gets the value of the blame property.
     * 
     * @return
     *     possible object is
     *     {@link Blame }
     *     
     */
    public Blame getBlame() {
        return blame;
    }

    /**
     * Sets the value of the blame property.
     * 
     * @param value
     *     allowed object is
     *     {@link Blame }
     *     
     */
    public void setBlame(Blame value) {
        this.blame = value;
    }

    /**
     * Gets the value of the problemLogged property.
     * 
     */
    public boolean isProblemLogged() {
        return problemLogged;
    }

    /**
     * Sets the value of the problemLogged property.
     * 
     */
    public void setProblemLogged(boolean value) {
        this.problemLogged = value;
    }

    /**
     * Gets the value of the retry property.
     * 
     * @return
     *     possible object is
     *     {@link Retry }
     *     
     */
    public Retry getRetry() {
        return retry;
    }

    /**
     * Sets the value of the retry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Retry }
     *     
     */
    public void setRetry(Retry value) {
        this.retry = value;
    }

}
