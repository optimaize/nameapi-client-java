
package org.nameapi.client.services.nameparser.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapParserResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapParserResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bestMatch" type="{http://nameparser.services.v4_0.soap.server.nameapi.org/}soapMatch" minOccurs="0"/>
 *         &lt;element name="matches" type="{http://nameparser.services.v4_0.soap.server.nameapi.org/}soapMatch" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shortestItemCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapParserResult", propOrder = {
    "bestMatch",
    "matches",
    "shortestItemCount"
})
public class SoapParserResult {

    protected SoapMatch bestMatch;
    @XmlElement(nillable = true)
    protected List<SoapMatch> matches;
    protected int shortestItemCount;

    /**
     * Gets the value of the bestMatch property.
     * 
     * @return
     *     possible object is
     *     {@link SoapMatch }
     *     
     */
    public SoapMatch getBestMatch() {
        return bestMatch;
    }

    /**
     * Sets the value of the bestMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoapMatch }
     *     
     */
    public void setBestMatch(SoapMatch value) {
        this.bestMatch = value;
    }

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
     * {@link SoapMatch }
     * 
     * 
     */
    public List<SoapMatch> getMatches() {
        if (matches == null) {
            matches = new ArrayList<SoapMatch>();
        }
        return this.matches;
    }

    /**
     * Gets the value of the shortestItemCount property.
     * 
     */
    public int getShortestItemCount() {
        return shortestItemCount;
    }

    /**
     * Sets the value of the shortestItemCount property.
     * 
     */
    public void setShortestItemCount(int value) {
        this.shortestItemCount = value;
    }

}
