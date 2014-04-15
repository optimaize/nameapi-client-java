
package org.nameapi.client.services.parser.personnameparser.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapPersonNameParserResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapPersonNameParserResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parsedPersonMatches" type="{http://personnameparser.parser.services.v4_0.soap.server.nameapi.org/}soapParsedPersonMatch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapPersonNameParserResult", propOrder = {
    "parsedPersonMatches"
})
public class SoapPersonNameParserResult {

    @XmlElement(nillable = true)
    protected List<SoapParsedPersonMatch> parsedPersonMatches;

    /**
     * Gets the value of the parsedPersonMatches property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parsedPersonMatches property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParsedPersonMatches().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapParsedPersonMatch }
     * 
     * 
     */
    public List<SoapParsedPersonMatch> getParsedPersonMatches() {
        if (parsedPersonMatches == null) {
            parsedPersonMatches = new ArrayList<SoapParsedPersonMatch>();
        }
        return this.parsedPersonMatches;
    }

}
