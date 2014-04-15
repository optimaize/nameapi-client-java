
package org.nameapi.client.commonwsdl.person;

import org.nameapi.ontology.input.entities.person.MaritalStatus;
import org.nameapi.ontology.input.entities.person.gender.StoragePersonGender;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for soapSimpleNaturalPerson complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="soapSimpleNaturalPerson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addresses" type="{http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/}soapAddressRelation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ageInfo" type="{http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/}soapAgeInfo" minOccurs="0"/>
 *         &lt;element name="correspondenceLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailAddresses" type="{http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/}soapEmailAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/}storagePersonGender" minOccurs="0"/>
 *         &lt;element name="maritalStatus" type="{http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/}maritalStatus" minOccurs="0"/>
 *         &lt;element name="nationalities" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nativeLanguages" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personName" type="{http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/}soapPersonName" minOccurs="0"/>
 *         &lt;element name="religion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telNumbers" type="{http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/}soapTelNumber" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="titles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapSimpleNaturalPerson", propOrder = {
        "addresses",
        "ageInfo",
        "correspondenceLanguage",
        "emailAddresses",
        "gender",
        "maritalStatus",
        "nationalities",
        "nativeLanguages",
        "personName",
        "religion",
        "telNumbers",
        "titles"
})
public class SoapSimpleNaturalPerson {

    @XmlElement(nillable = true)
    protected List<SoapAddressRelation> addresses;
    protected SoapAgeInfo ageInfo;
    protected String correspondenceLanguage;
    @XmlElement(nillable = true)
    protected List<SoapEmailAddress> emailAddresses;
    protected StoragePersonGender gender;
    protected MaritalStatus maritalStatus;
    @XmlElement(nillable = true)
    protected List<String> nationalities;
    @XmlElement(nillable = true)
    protected List<String> nativeLanguages;
    protected SoapPersonName personName;
    protected String religion;
    @XmlElement(nillable = true)
    protected List<SoapTelNumber> telNumbers;
    @XmlElement(nillable = true)
    protected List<String> titles;

    /**
     * Gets the value of the addresses property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addresses property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddresses().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapAddressRelation }
     *
     *
     */
    public List<SoapAddressRelation> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<SoapAddressRelation>();
        }
        return this.addresses;
    }

    /**
     * Gets the value of the ageInfo property.
     *
     * @return
     *     possible object is
     *     {@link SoapAgeInfo }
     *
     */
    public SoapAgeInfo getAgeInfo() {
        return ageInfo;
    }

    /**
     * Sets the value of the ageInfo property.
     *
     * @param value
     *     allowed object is
     *     {@link SoapAgeInfo }
     *
     */
    public void setAgeInfo(SoapAgeInfo value) {
        this.ageInfo = value;
    }

    /**
     * Gets the value of the correspondenceLanguage property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCorrespondenceLanguage() {
        return correspondenceLanguage;
    }

    /**
     * Sets the value of the correspondenceLanguage property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCorrespondenceLanguage(String value) {
        this.correspondenceLanguage = value;
    }

    /**
     * Gets the value of the emailAddresses property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emailAddresses property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmailAddresses().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapEmailAddress }
     *
     *
     */
    public List<SoapEmailAddress> getEmailAddresses() {
        if (emailAddresses == null) {
            emailAddresses = new ArrayList<SoapEmailAddress>();
        }
        return this.emailAddresses;
    }

    /**
     * Gets the value of the gender property.
     *
     * @return
     *     possible object is
     *     {@link org.nameapi.ontology.input.entities.person.gender.StoragePersonGender }
     *
     */
    public StoragePersonGender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     *
     * @param value
     *     allowed object is
     *     {@link org.nameapi.ontology.input.entities.person.gender.StoragePersonGender }
     *
     */
    public void setGender(StoragePersonGender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     *
     * @return
     *     possible object is
     *     {@link org.nameapi.ontology.input.entities.person.MaritalStatus }
     *
     */
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link org.nameapi.ontology.input.entities.person.MaritalStatus }
     *
     */
    public void setMaritalStatus(MaritalStatus value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the nationalities property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nationalities property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNationalities().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getNationalities() {
        if (nationalities == null) {
            nationalities = new ArrayList<String>();
        }
        return this.nationalities;
    }

    /**
     * Gets the value of the nativeLanguages property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nativeLanguages property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNativeLanguages().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getNativeLanguages() {
        if (nativeLanguages == null) {
            nativeLanguages = new ArrayList<String>();
        }
        return this.nativeLanguages;
    }

    /**
     * Gets the value of the personName property.
     *
     * @return
     *     possible object is
     *     {@link SoapPersonName }
     *
     */
    public SoapPersonName getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     *
     * @param value
     *     allowed object is
     *     {@link SoapPersonName }
     *
     */
    public void setPersonName(SoapPersonName value) {
        this.personName = value;
    }

    /**
     * Gets the value of the religion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReligion() {
        return religion;
    }

    /**
     * Sets the value of the religion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReligion(String value) {
        this.religion = value;
    }

    /**
     * Gets the value of the telNumbers property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the telNumbers property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTelNumbers().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoapTelNumber }
     *
     *
     */
    public List<SoapTelNumber> getTelNumbers() {
        if (telNumbers == null) {
            telNumbers = new ArrayList<SoapTelNumber>();
        }
        return this.telNumbers;
    }

    /**
     * Gets the value of the titles property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the titles property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTitles().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getTitles() {
        if (titles == null) {
            titles = new ArrayList<String>();
        }
        return this.titles;
    }

}
