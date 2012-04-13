
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStructureSearch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStructureSearch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="structure" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.ebi.ac.uk/webservices/chebi}StructureType"/>
 *         &lt;element name="structureSearchCategory" type="{http://www.ebi.ac.uk/webservices/chebi}StructureSearchCategory"/>
 *         &lt;element name="totalResults" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tanimotoCutoff" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStructureSearch", propOrder = {
    "structure",
    "type",
    "structureSearchCategory",
    "totalResults",
    "tanimotoCutoff"
})
public class GetStructureSearch {

    @XmlElement(required = true)
    protected String structure;
    @XmlElement(required = true)
    protected StructureType type;
    @XmlElement(required = true)
    protected StructureSearchCategory structureSearchCategory;
    protected int totalResults;
    protected float tanimotoCutoff;

    /**
     * Gets the value of the structure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStructure() {
        return structure;
    }

    /**
     * Sets the value of the structure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStructure(String value) {
        this.structure = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link StructureType }
     *     
     */
    public StructureType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructureType }
     *     
     */
    public void setType(StructureType value) {
        this.type = value;
    }

    /**
     * Gets the value of the structureSearchCategory property.
     * 
     * @return
     *     possible object is
     *     {@link StructureSearchCategory }
     *     
     */
    public StructureSearchCategory getStructureSearchCategory() {
        return structureSearchCategory;
    }

    /**
     * Sets the value of the structureSearchCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructureSearchCategory }
     *     
     */
    public void setStructureSearchCategory(StructureSearchCategory value) {
        this.structureSearchCategory = value;
    }

    /**
     * Gets the value of the totalResults property.
     * 
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     * Sets the value of the totalResults property.
     * 
     */
    public void setTotalResults(int value) {
        this.totalResults = value;
    }

    /**
     * Gets the value of the tanimotoCutoff property.
     * 
     */
    public float getTanimotoCutoff() {
        return tanimotoCutoff;
    }

    /**
     * Sets the value of the tanimotoCutoff property.
     * 
     */
    public void setTanimotoCutoff(float value) {
        this.tanimotoCutoff = value;
    }

}
