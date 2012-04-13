
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StarsCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StarsCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="TWO ONLY"/>
 *     &lt;enumeration value="THREE ONLY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StarsCategory")
@XmlEnum
public enum StarsCategory {

    ALL("ALL"),
    @XmlEnumValue("TWO ONLY")
    TWO_ONLY("TWO ONLY"),
    @XmlEnumValue("THREE ONLY")
    THREE_ONLY("THREE ONLY");
    private final String value;

    StarsCategory(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StarsCategory fromValue(String v) {
        for (StarsCategory c: StarsCategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
