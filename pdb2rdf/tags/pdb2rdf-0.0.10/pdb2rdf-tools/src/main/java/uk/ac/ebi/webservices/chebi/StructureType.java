
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StructureType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StructureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MOLFILE"/>
 *     &lt;enumeration value="CML"/>
 *     &lt;enumeration value="SMILES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StructureType")
@XmlEnum
public enum StructureType {

    MOLFILE,
    CML,
    SMILES;

    public String value() {
        return name();
    }

    public static StructureType fromValue(String v) {
        return valueOf(v);
    }

}
