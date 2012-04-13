
package uk.ac.ebi.webservices.chebi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OntologyDataItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OntologyDataItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chebiName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chebiId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cyclicRelationship" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Comments" type="{http://www.ebi.ac.uk/webservices/chebi}CommentDataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OntologyElement" type="{http://www.ebi.ac.uk/webservices/chebi}OntologyDataItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OntologyDataItem", propOrder = {
    "chebiName",
    "chebiId",
    "type",
    "status",
    "cyclicRelationship",
    "comments",
    "ontologyElement"
})
public class OntologyDataItem {

    @XmlElement(required = true)
    protected String chebiName;
    @XmlElement(required = true)
    protected String chebiId;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String status;
    protected boolean cyclicRelationship;
    @XmlElement(name = "Comments")
    protected List<CommentDataItem> comments;
    @XmlElement(name = "OntologyElement")
    protected List<OntologyDataItem> ontologyElement;

    /**
     * Gets the value of the chebiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChebiName() {
        return chebiName;
    }

    /**
     * Sets the value of the chebiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChebiName(String value) {
        this.chebiName = value;
    }

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the cyclicRelationship property.
     * 
     */
    public boolean isCyclicRelationship() {
        return cyclicRelationship;
    }

    /**
     * Sets the value of the cyclicRelationship property.
     * 
     */
    public void setCyclicRelationship(boolean value) {
        this.cyclicRelationship = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommentDataItem }
     * 
     * 
     */
    public List<CommentDataItem> getComments() {
        if (comments == null) {
            comments = new ArrayList<CommentDataItem>();
        }
        return this.comments;
    }

    /**
     * Gets the value of the ontologyElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ontologyElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOntologyElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OntologyDataItem }
     * 
     * 
     */
    public List<OntologyDataItem> getOntologyElement() {
        if (ontologyElement == null) {
            ontologyElement = new ArrayList<OntologyDataItem>();
        }
        return this.ontologyElement;
    }

}
