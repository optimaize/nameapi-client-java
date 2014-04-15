
package org.nameapi.client.services.nameparser.wsdl;

import org.nameapi.client.commonwsdl.context.SoapContext;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://nameparser.services.v4_0.soap.server.nameapi.org/}soapSimpleContext"/>
 *         &lt;element name="nameString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rules" type="{http://nameparser.services.v4_0.soap.server.nameapi.org/}soapNameParserRule" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parse", propOrder = {
    "context",
    "nameString",
    "rules"
})
public class Parse {

    @XmlElement(required = true)
    protected SoapContext context;
    @XmlElement(required = true)
    protected String nameString;
    @XmlElement(required = true)
    protected List<SoapNameParserRule> rules;

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
     * Gets the value of the nameString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameString() {
        return nameString;
    }

    /**
     * Sets the value of the nameString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameString(String value) {
        this.nameString = value;
    }

    /**
     * Gets the value of the rules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapNameParserRule }
     * 
     * 
     */
    public List<SoapNameParserRule> getRules() {
        if (rules == null) {
            rules = new ArrayList<SoapNameParserRule>();
        }
        return this.rules;
    }

}
