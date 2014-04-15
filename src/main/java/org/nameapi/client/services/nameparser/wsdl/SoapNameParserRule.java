
package org.nameapi.client.services.nameparser.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapNameParserRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapNameParserRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruleString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapNameParserRule", propOrder = {
    "chance",
    "name",
    "ruleString"
})
public class SoapNameParserRule {

    protected int chance;
    protected String name;
    protected String ruleString;

    /**
     * Gets the value of the chance property.
     * 
     */
    public int getChance() {
        return chance;
    }

    /**
     * Sets the value of the chance property.
     * 
     */
    public void setChance(int value) {
        this.chance = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the ruleString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleString() {
        return ruleString;
    }

    /**
     * Sets the value of the ruleString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleString(String value) {
        this.ruleString = value;
    }

}
