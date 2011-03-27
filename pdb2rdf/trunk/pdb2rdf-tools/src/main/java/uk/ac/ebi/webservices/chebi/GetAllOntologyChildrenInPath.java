
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllOntologyChildrenInPath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllOntologyChildrenInPath">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chebiId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="relationshipType" type="{http://www.ebi.ac.uk/webservices/chebi}RelationshipType"/>
 *         &lt;element name="structureOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllOntologyChildrenInPath", propOrder = {
    "chebiId",
    "relationshipType",
    "structureOnly"
})
public class GetAllOntologyChildrenInPath {

    @XmlElement(required = true)
    protected String chebiId;
    @XmlElement(required = true)
    protected RelationshipType relationshipType;
    protected boolean structureOnly;

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

    /**
     * Gets the value of the relationshipType property.
     * 
     * @return
     *     possible object is
     *     {@link RelationshipType }
     *     
     */
    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    /**
     * Sets the value of the relationshipType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationshipType }
     *     
     */
    public void setRelationshipType(RelationshipType value) {
        this.relationshipType = value;
    }

    /**
     * Gets the value of the structureOnly property.
     * 
     */
    public boolean isStructureOnly() {
        return structureOnly;
    }

    /**
     * Sets the value of the structureOnly property.
     * 
     */
    public void setStructureOnly(boolean value) {
        this.structureOnly = value;
    }

}
