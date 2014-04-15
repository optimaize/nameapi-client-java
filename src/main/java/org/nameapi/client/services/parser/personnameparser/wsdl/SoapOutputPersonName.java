
package org.nameapi.client.services.parser.personnameparser.wsdl;

import org.nameapi.client.services.nameparser.fieldnameparser.wsdl.SoapTerm;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapOutputPersonName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapOutputPersonName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="terms" type="{http://personnameparser.parser.services.v4_0.soap.server.nameapi.org/}soapTerm" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapOutputPersonName", propOrder = {
    "terms"
})
public class SoapOutputPersonName {

    @XmlElement(nillable = true)
    protected List<SoapTerm> terms;

    /**
     * Gets the value of the terms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the terms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapTerm }
     * 
     * 
     */
    public List<SoapTerm> getTerms() {
        if (terms == null) {
            terms = new ArrayList<SoapTerm>();
        }
        return this.terms;
    }

}
