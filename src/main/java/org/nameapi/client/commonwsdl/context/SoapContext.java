
package org.nameapi.client.commonwsdl.context;

import org.nameapi.ontology.input.context.Priority;
import org.nameapi.ontology.input.context.TextCase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for soapContext complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="soapContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="geo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://ping.system.services.v4_0.soap.server.nameapi.org/}priority" minOccurs="0"/>
 *         &lt;element name="properties">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="textCase" type="{http://ping.system.services.v4_0.soap.server.nameapi.org/}textCase" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soapContext", propOrder = {
        "apiKey",
        "geo",
        "priority",
        "properties",
        "textCase"
})
public class SoapContext {

    protected String apiKey;
    protected String geo;
    protected Priority priority;
    @XmlElement(required = true)
    protected SoapContext.Properties properties;
    protected TextCase textCase;

    /**
     * Gets the value of the apiKey property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the value of the apiKey property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setApiKey(String value) {
        this.apiKey = value;
    }

    /**
     * Gets the value of the geo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGeo() {
        return geo;
    }

    /**
     * Sets the value of the geo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGeo(String value) {
        this.geo = value;
    }

    /**
     * Gets the value of the priority property.
     *
     * @return
     *     possible object is
     *     {@link org.nameapi.ontology.input.context.Priority }
     *
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     *
     * @param value
     *     allowed object is
     *     {@link org.nameapi.ontology.input.context.Priority }
     *
     */
    public void setPriority(Priority value) {
        this.priority = value;
    }

    /**
     * Gets the value of the properties property.
     *
     * @return
     *     possible object is
     *     {@link org.nameapi.client.commonwsdl.context.SoapContext.Properties }
     *
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     *
     * @param value
     *     allowed object is
     *     {@link org.nameapi.client.commonwsdl.context.SoapContext.Properties }
     *
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

    /**
     * Gets the value of the textCase property.
     *
     * @return
     *     possible object is
     *     {@link org.nameapi.ontology.input.context.TextCase }
     *
     */
    public TextCase getTextCase() {
        return textCase;
    }

    /**
     * Sets the value of the textCase property.
     *
     * @param value
     *     allowed object is
     *     {@link org.nameapi.ontology.input.context.TextCase }
     *
     */
    public void setTextCase(TextCase value) {
        this.textCase = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "entry"
    })
    public static class Properties {

        protected List<Entry> entry;

        /**
         * Gets the value of the entry property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link org.nameapi.client.commonwsdl.context.SoapContext.Properties.Entry }
         *
         *
         */
        public List<Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<Entry>();
            }
            return this.entry;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "key",
                "value"
        })
        public static class Entry {

            protected String key;
            protected String value;

            /**
             * Gets the value of the key property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * Gets the value of the value property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }

}
