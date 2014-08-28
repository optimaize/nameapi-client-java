
package org.nameapi.client.services.parser.personnameparser.wsdl;

import org.nameapi.ontology4.input.entities.person.PersonType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapParsedPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapParsedPerson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="names" type="{http://personnameparser.parser.services.v4_0.soap.server.nameapi.org/}soapOutputPersonName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personType" type="{http://personnameparser.parser.services.v4_0.soap.server.nameapi.org/}personType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapParsedPerson", propOrder = {
    "names",
    "personType"
})
public class SoapParsedPerson {

    @XmlElement(nillable = true)
    protected List<SoapOutputPersonName> names;
    protected PersonType personType;

    /**
     * Gets the value of the names property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the names property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapOutputPersonName }
     * 
     * 
     */
    public List<SoapOutputPersonName> getNames() {
        if (names == null) {
            names = new ArrayList<SoapOutputPersonName>();
        }
        return this.names;
    }

    /**
     * Gets the value of the personType property.
     * 
     * @return
     *     possible object is
     *     {@link org.nameapi.ontology4.input.entities.person.PersonType }
     *     
     */
    public PersonType getPersonType() {
        return personType;
    }

    /**
     * Sets the value of the personType property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.nameapi.ontology4.input.entities.person.PersonType }
     *     
     */
    public void setPersonType(PersonType value) {
        this.personType = value;
    }

}
