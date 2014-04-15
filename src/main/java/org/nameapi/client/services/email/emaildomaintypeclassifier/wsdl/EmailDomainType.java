package org.nameapi.client.services.email.emaildomaintypeclassifier.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 */
@XmlType(name = "emailDomainType")
@XmlEnum
public enum EmailDomainType {

    /**
     * Trash domains such as mailinator.com.
     */
    DISPOSABLE,

    /**
     * Freemail providers such as yahoo.com.
     */
    FREEMAIL,

    /**
     * Internet service providers such as aol.com.
     */
    ISP,

    /**
     * Businesses, universities etc. such as google.com.
     */
    ORGANIZATION,

    /**
     * Non-commercial private domains from individuals.
     */
    PRIVATE,

    /**
     * Reserved domain names serving as examples in documentation, such as example.com.
     */
    EXAMPLE,

    /**
     * Unclassified as of now.
     */
    UNKNOWN;

    public String value() {
        return name();
    }

    public static EmailDomainType fromValue(String v) {
        return valueOf(v);
    }

}
