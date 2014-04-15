
package org.nameapi.client.commonwsdl.person;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapAgeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soapAgeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="birthDay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="birthMonth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="birthYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="birthYearRange" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapAgeInfo", propOrder = {
    "birthDay",
    "birthMonth",
    "birthYear",
    "birthYearRange"
})
public class SoapAgeInfo {

    protected Integer birthDay;
    protected Integer birthMonth;
    protected Integer birthYear;
    @XmlElement(nillable = true)
    protected List<Integer> birthYearRange;

    /**
     * Gets the value of the birthDay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBirthDay() {
        return birthDay;
    }

    /**
     * Sets the value of the birthDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBirthDay(Integer value) {
        this.birthDay = value;
    }

    /**
     * Gets the value of the birthMonth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBirthMonth() {
        return birthMonth;
    }

    /**
     * Sets the value of the birthMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBirthMonth(Integer value) {
        this.birthMonth = value;
    }

    /**
     * Gets the value of the birthYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBirthYear() {
        return birthYear;
    }

    /**
     * Sets the value of the birthYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBirthYear(Integer value) {
        this.birthYear = value;
    }

    /**
     * Gets the value of the birthYearRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the birthYearRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBirthYearRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getBirthYearRange() {
        if (birthYearRange == null) {
            birthYearRange = new ArrayList<Integer>();
        }
        return this.birthYearRange;
    }

}
