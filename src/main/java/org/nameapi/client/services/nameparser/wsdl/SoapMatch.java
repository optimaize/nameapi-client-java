
package org.nameapi.client.services.nameparser.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="certainty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="culture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="itemsAsStrings" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ruleChance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ruleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapMatch", propOrder = {
    "certainty",
    "culture",
    "itemCount",
    "itemsAsStrings",
    "ruleChance",
    "ruleName"
})
public class SoapMatch {

    protected int certainty;
    protected String culture;
    protected int itemCount;
    @XmlElement(nillable = true)
    protected List<String> itemsAsStrings;
    protected int ruleChance;
    protected String ruleName;

    /**
     * Gets the value of the certainty property.
     * 
     */
    public int getCertainty() {
        return certainty;
    }

    /**
     * Sets the value of the certainty property.
     * 
     */
    public void setCertainty(int value) {
        this.certainty = value;
    }

    /**
     * Gets the value of the culture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCulture() {
        return culture;
    }

    /**
     * Sets the value of the culture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCulture(String value) {
        this.culture = value;
    }

    /**
     * Gets the value of the itemCount property.
     * 
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Sets the value of the itemCount property.
     * 
     */
    public void setItemCount(int value) {
        this.itemCount = value;
    }

    /**
     * Gets the value of the itemsAsStrings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemsAsStrings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemsAsStrings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getItemsAsStrings() {
        if (itemsAsStrings == null) {
            itemsAsStrings = new ArrayList<String>();
        }
        return this.itemsAsStrings;
    }

    /**
     * Gets the value of the ruleChance property.
     * 
     */
    public int getRuleChance() {
        return ruleChance;
    }

    /**
     * Sets the value of the ruleChance property.
     * 
     */
    public void setRuleChance(int value) {
        this.ruleChance = value;
    }

    /**
     * Gets the value of the ruleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * Sets the value of the ruleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleName(String value) {
        this.ruleName = value;
    }

}
