
package org.nameapi.client.commonwsdl.person;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapWesternPersonNameSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapWesternPersonNameSet">
 *   &lt;complexContent>
 *     &lt;extension base="{http://genderizer.services.v4_0.soap.server.nameapi.org/}soapPersonName">
 *       &lt;sequence>
 *         &lt;element name="givenNames" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="surnames" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapWesternPersonNameSet", propOrder = {
    "givenNames",
    "surnames"
})
public class SoapWesternPersonNameSet
    extends SoapPersonName
{

    @XmlElement(nillable = true)
    protected List<String> givenNames;
    @XmlElement(nillable = true)
    protected List<String> surnames;

    /**
     * Gets the value of the givenNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the givenNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGivenNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGivenNames() {
        if (givenNames == null) {
            givenNames = new ArrayList<String>();
        }
        return this.givenNames;
    }

    /**
     * Gets the value of the surnames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surnames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurnames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSurnames() {
        if (surnames == null) {
            surnames = new ArrayList<String>();
        }
        return this.surnames;
    }

}
