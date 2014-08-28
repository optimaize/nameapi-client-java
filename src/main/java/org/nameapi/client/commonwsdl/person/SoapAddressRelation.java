
package org.nameapi.client.commonwsdl.person;

//import org.nameapi.ontology4.input.entities.address.AddressUsage;

import org.nameapi.ontology4.input.entities.address.AddressUsage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapAddressRelation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapAddressRelation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://genderizer.services.v4_0.soap.server.nameapi.org/}soapAddress" minOccurs="0"/>
 *         &lt;element name="specificUsage" type="{http://genderizer.services.v4_0.soap.server.nameapi.org/}addressUsage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usageForAll" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapAddressRelation", propOrder = {
    "address",
    "specificUsage",
    "usageForAll"
})
public class SoapAddressRelation {

    protected SoapAddress address;
    @XmlElement(nillable = true)
    protected List<AddressUsage> specificUsage;
    protected boolean usageForAll;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link SoapAddress }
     *     
     */
    public SoapAddress getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapAddress }
     *     
     */
    public void setAddress(SoapAddress value) {
        this.address = value;
    }

    /**
     * Gets the value of the specificUsage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specificUsage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecificUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link org.nameapi.ontology4.input.entities.address.AddressUsage }
     * 
     * 
     */
    public List<AddressUsage> getSpecificUsage() {
        if (specificUsage == null) {
            specificUsage = new ArrayList<AddressUsage>();
        }
        return this.specificUsage;
    }

    /**
     * Gets the value of the usageForAll property.
     * 
     */
    public boolean isUsageForAll() {
        return usageForAll;
    }

    /**
     * Sets the value of the usageForAll property.
     * 
     */
    public void setUsageForAll(boolean value) {
        this.usageForAll = value;
    }

}
