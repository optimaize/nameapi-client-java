
package org.nameapi.client.commonwsdl.exception;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for blame.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="blame">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SERVER_UNKNOWN"/>
 *     &lt;enumeration value="SERVER_CODE"/>
 *     &lt;enumeration value="SERVER_DATA"/>
 *     &lt;enumeration value="SERVER_CIRCUMSTANCE"/>
 *     &lt;enumeration value="SERVER_PERFORMANCE"/>
 *     &lt;enumeration value="CLIENT_DATA"/>
 *     &lt;enumeration value="CLIENT_LOGIC"/>
 *     &lt;enumeration value="CLIENT_BEHAVIOR"/>
 *     &lt;enumeration value="CLIENT_CODE"/>
 *     &lt;enumeration value="NETWORK"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "blame")
@XmlEnum
public enum Blame {

    SERVER_UNKNOWN,
    SERVER_CODE,
    SERVER_DATA,
    SERVER_CIRCUMSTANCE,
    SERVER_PERFORMANCE,
    CLIENT_DATA,
    CLIENT_LOGIC,
    CLIENT_BEHAVIOR,
    CLIENT_CODE,
    NETWORK,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static Blame fromValue(String v) {
        return valueOf(v);
    }

    public static void assertSize(int expectedItems) {
        assert values().length == expectedItems : "Update the code calling this with " + expectedItems + "!";
    }
}
