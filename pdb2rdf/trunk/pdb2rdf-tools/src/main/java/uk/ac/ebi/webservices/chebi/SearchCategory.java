
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL"/>
 *     &lt;enumeration value="CHEBI ID"/>
 *     &lt;enumeration value="CHEBI NAME"/>
 *     &lt;enumeration value="DEFINITION"/>
 *     &lt;enumeration value="ALL NAMES"/>
 *     &lt;enumeration value="IUPAC NAME"/>
 *     &lt;enumeration value="DATABASE LINK/REGISTRY NUMBER/CITATION"/>
 *     &lt;enumeration value="FORMULA"/>
 *     &lt;enumeration value="MASS"/>
 *     &lt;enumeration value="CHARGE"/>
 *     &lt;enumeration value="INCHI/INCHI KEY"/>
 *     &lt;enumeration value="SMILES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchCategory")
@XmlEnum
public enum SearchCategory {

    ALL("ALL"),
    @XmlEnumValue("CHEBI ID")
    CHEBI_ID("CHEBI ID"),
    @XmlEnumValue("CHEBI NAME")
    CHEBI_NAME("CHEBI NAME"),
    DEFINITION("DEFINITION"),
    @XmlEnumValue("ALL NAMES")
    ALL_NAMES("ALL NAMES"),
    @XmlEnumValue("IUPAC NAME")
    IUPAC_NAME("IUPAC NAME"),
    @XmlEnumValue("DATABASE LINK/REGISTRY NUMBER/CITATION")
    DATABASE_LINK_REGISTRY_NUMBER_CITATION("DATABASE LINK/REGISTRY NUMBER/CITATION"),
    FORMULA("FORMULA"),
    MASS("MASS"),
    CHARGE("CHARGE"),
    @XmlEnumValue("INCHI/INCHI KEY")
    INCHI_INCHI_KEY("INCHI/INCHI KEY"),
    SMILES("SMILES");
    private final String value;

    SearchCategory(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchCategory fromValue(String v) {
        for (SearchCategory c: SearchCategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
