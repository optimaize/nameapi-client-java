
package org.nameapi.client.commonwsdl.exception;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for retry.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="retry">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NO"/>
 *     &lt;enumeration value="LATER"/>
 *     &lt;enumeration value="NOW"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "retry")
@XmlEnum
public enum Retry {

    NO,
    LATER,
    NOW,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static Retry fromValue(String v) {
        return valueOf(v);
    }

}
