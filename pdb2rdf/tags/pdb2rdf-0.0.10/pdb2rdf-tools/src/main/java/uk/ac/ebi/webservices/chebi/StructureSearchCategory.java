
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StructureSearchCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StructureSearchCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IDENTITY"/>
 *     &lt;enumeration value="SUBSTRUCTURE"/>
 *     &lt;enumeration value="SIMILARITY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StructureSearchCategory")
@XmlEnum
public enum StructureSearchCategory {

    IDENTITY,
    SUBSTRUCTURE,
    SIMILARITY;

    public String value() {
        return name();
    }

    public static StructureSearchCategory fromValue(String v) {
        return valueOf(v);
    }

}
