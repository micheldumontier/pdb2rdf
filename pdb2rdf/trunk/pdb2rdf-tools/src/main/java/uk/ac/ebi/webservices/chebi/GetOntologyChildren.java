
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getOntologyChildren complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getOntologyChildren">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chebiId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOntologyChildren", propOrder = {
    "chebiId"
})
public class GetOntologyChildren {

    @XmlElement(required = true)
    protected String chebiId;

    /**
     * Gets the value of the chebiId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChebiId() {
        return chebiId;
    }

    /**
     * Sets the value of the chebiId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChebiId(String value) {
        this.chebiId = value;
    }

}
