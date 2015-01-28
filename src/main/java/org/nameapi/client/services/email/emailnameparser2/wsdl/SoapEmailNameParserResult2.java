
package org.nameapi.client.services.email.emailnameparser2.wsdl;

import org.nameapi.client.services.email.emailnameparser2.EmailAddressParsingResultType2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapEmailNameParserResult2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapEmailNameParserResult2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="matches" type="{http://emailnameparser2.email.services.v4_0.soap.server.nameapi.org/}soapEmailNameParserMatch" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resultType" type="{http://emailnameparser2.email.services.v4_0.soap.server.nameapi.org/}emailAddressParsingResultType2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapEmailNameParserResult2", propOrder = {
    "matches",
    "resultType"
})
public class SoapEmailNameParserResult2 {

    @XmlElement(nillable = true)
    protected List<SoapEmailNameParserMatch> matches;
    protected EmailAddressParsingResultType2 resultType;

    /**
     * Gets the value of the matches property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matches property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatches().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapEmailNameParserMatch }
     * 
     * 
     */
    public List<SoapEmailNameParserMatch> getMatches() {
        if (matches == null) {
            matches = new ArrayList<SoapEmailNameParserMatch>();
        }
        return this.matches;
    }

    /**
     * Gets the value of the resultType property.
     * 
     * @return
     *     possible object is
     *     {@link EmailAddressParsingResultType2 }
     *     
     */
    public EmailAddressParsingResultType2 getResultType() {
        return resultType;
    }

    /**
     * Sets the value of the resultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailAddressParsingResultType2 }
     *     
     */
    public void setResultType(EmailAddressParsingResultType2 value) {
        this.resultType = value;
    }

}
