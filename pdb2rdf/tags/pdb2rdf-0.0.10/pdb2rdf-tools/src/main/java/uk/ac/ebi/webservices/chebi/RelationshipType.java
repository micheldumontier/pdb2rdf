
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelationshipType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelationshipType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="is a"/>
 *     &lt;enumeration value="has part"/>
 *     &lt;enumeration value="is conjugate base of"/>
 *     &lt;enumeration value="is conjugate acid of"/>
 *     &lt;enumeration value="is tautomer of"/>
 *     &lt;enumeration value="is enantiomer of"/>
 *     &lt;enumeration value="has functional parent"/>
 *     &lt;enumeration value="has parent hydride"/>
 *     &lt;enumeration value="is substituent group from"/>
 *     &lt;enumeration value="has role"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelationshipType")
@XmlEnum
public enum RelationshipType {

    @XmlEnumValue("is a")
    IS_A("is a"),
    @XmlEnumValue("has part")
    HAS_PART("has part"),
    @XmlEnumValue("is conjugate base of")
    IS_CONJUGATE_BASE_OF("is conjugate base of"),
    @XmlEnumValue("is conjugate acid of")
    IS_CONJUGATE_ACID_OF("is conjugate acid of"),
    @XmlEnumValue("is tautomer of")
    IS_TAUTOMER_OF("is tautomer of"),
    @XmlEnumValue("is enantiomer of")
    IS_ENANTIOMER_OF("is enantiomer of"),
    @XmlEnumValue("has functional parent")
    HAS_FUNCTIONAL_PARENT("has functional parent"),
    @XmlEnumValue("has parent hydride")
    HAS_PARENT_HYDRIDE("has parent hydride"),
    @XmlEnumValue("is substituent group from")
    IS_SUBSTITUENT_GROUP_FROM("is substituent group from"),
    @XmlEnumValue("has role")
    HAS_ROLE("has role");
    private final String value;

    RelationshipType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelationshipType fromValue(String v) {
        for (RelationshipType c: RelationshipType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
