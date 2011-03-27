
package uk.ac.ebi.webservices.chebi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Entity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Entity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chebiId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chebiAsciiName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="definition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="smiles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inchi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inchiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="charge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="entityStar" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SecondaryChEBIIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Synonyms" type="{http://www.ebi.ac.uk/webservices/chebi}DataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IupacNames" type="{http://www.ebi.ac.uk/webservices/chebi}DataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Formulae" type="{http://www.ebi.ac.uk/webservices/chebi}DataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RegistryNumbers" type="{http://www.ebi.ac.uk/webservices/chebi}DataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Citations" type="{http://www.ebi.ac.uk/webservices/chebi}DataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ChemicalStructures" type="{http://www.ebi.ac.uk/webservices/chebi}StructureDataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DatabaseLinks" type="{http://www.ebi.ac.uk/webservices/chebi}DataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OntologyParents" type="{http://www.ebi.ac.uk/webservices/chebi}OntologyDataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OntologyChildren" type="{http://www.ebi.ac.uk/webservices/chebi}OntologyDataItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GeneralComments" type="{http://www.ebi.ac.uk/webservices/chebi}CommentDataItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Entity", propOrder = {
    "chebiId",
    "chebiAsciiName",
    "definition",
    "status",
    "smiles",
    "inchi",
    "inchiKey",
    "charge",
    "mass",
    "entityStar",
    "secondaryChEBIIds",
    "synonyms",
    "iupacNames",
    "formulae",
    "registryNumbers",
    "citations",
    "chemicalStructures",
    "databaseLinks",
    "ontologyParents",
    "ontologyChildren",
    "generalComments"
})
public class Entity {

    @XmlElement(required = true)
    protected String chebiId;
    @XmlElement(required = true)
    protected String chebiAsciiName;
    protected String definition;
    @XmlElement(required = true)
    protected String status;
    protected String smiles;
    protected String inchi;
    protected String inchiKey;
    protected String charge;
    protected String mass;
    protected Integer entityStar;
    @XmlElement(name = "SecondaryChEBIIds")
    protected List<String> secondaryChEBIIds;
    @XmlElement(name = "Synonyms")
    protected List<DataItem> synonyms;
    @XmlElement(name = "IupacNames")
    protected List<DataItem> iupacNames;
    @XmlElement(name = "Formulae")
    protected List<DataItem> formulae;
    @XmlElement(name = "RegistryNumbers")
    protected List<DataItem> registryNumbers;
    @XmlElement(name = "Citations")
    protected List<DataItem> citations;
    @XmlElement(name = "ChemicalStructures")
    protected List<StructureDataItem> chemicalStructures;
    @XmlElement(name = "DatabaseLinks")
    protected List<DataItem> databaseLinks;
    @XmlElement(name = "OntologyParents")
    protected List<OntologyDataItem> ontologyParents;
    @XmlElement(name = "OntologyChildren")
    protected List<OntologyDataItem> ontologyChildren;
    @XmlElement(name = "GeneralComments")
    protected List<CommentDataItem> generalComments;

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
     * Gets the value of the chebiAsciiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChebiAsciiName() {
        return chebiAsciiName;
    }

    /**
     * Sets the value of the chebiAsciiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChebiAsciiName(String value) {
        this.chebiAsciiName = value;
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinition(String value) {
        this.definition = value;
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
     * Gets the value of the smiles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmiles() {
        return smiles;
    }

    /**
     * Sets the value of the smiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmiles(String value) {
        this.smiles = value;
    }

    /**
     * Gets the value of the inchi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInchi() {
        return inchi;
    }

    /**
     * Sets the value of the inchi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInchi(String value) {
        this.inchi = value;
    }

    /**
     * Gets the value of the inchiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInchiKey() {
        return inchiKey;
    }

    /**
     * Sets the value of the inchiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInchiKey(String value) {
        this.inchiKey = value;
    }

    /**
     * Gets the value of the charge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharge() {
        return charge;
    }

    /**
     * Sets the value of the charge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharge(String value) {
        this.charge = value;
    }

    /**
     * Gets the value of the mass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMass() {
        return mass;
    }

    /**
     * Sets the value of the mass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMass(String value) {
        this.mass = value;
    }

    /**
     * Gets the value of the entityStar property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEntityStar() {
        return entityStar;
    }

    /**
     * Sets the value of the entityStar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEntityStar(Integer value) {
        this.entityStar = value;
    }

    /**
     * Gets the value of the secondaryChEBIIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the secondaryChEBIIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecondaryChEBIIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSecondaryChEBIIds() {
        if (secondaryChEBIIds == null) {
            secondaryChEBIIds = new ArrayList<String>();
        }
        return this.secondaryChEBIIds;
    }

    /**
     * Gets the value of the synonyms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the synonyms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSynonyms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItem }
     * 
     * 
     */
    public List<DataItem> getSynonyms() {
        if (synonyms == null) {
            synonyms = new ArrayList<DataItem>();
        }
        return this.synonyms;
    }

    /**
     * Gets the value of the iupacNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iupacNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIupacNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItem }
     * 
     * 
     */
    public List<DataItem> getIupacNames() {
        if (iupacNames == null) {
            iupacNames = new ArrayList<DataItem>();
        }
        return this.iupacNames;
    }

    /**
     * Gets the value of the formulae property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the formulae property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFormulae().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItem }
     * 
     * 
     */
    public List<DataItem> getFormulae() {
        if (formulae == null) {
            formulae = new ArrayList<DataItem>();
        }
        return this.formulae;
    }

    /**
     * Gets the value of the registryNumbers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registryNumbers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistryNumbers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItem }
     * 
     * 
     */
    public List<DataItem> getRegistryNumbers() {
        if (registryNumbers == null) {
            registryNumbers = new ArrayList<DataItem>();
        }
        return this.registryNumbers;
    }

    /**
     * Gets the value of the citations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the citations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCitations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItem }
     * 
     * 
     */
    public List<DataItem> getCitations() {
        if (citations == null) {
            citations = new ArrayList<DataItem>();
        }
        return this.citations;
    }

    /**
     * Gets the value of the chemicalStructures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chemicalStructures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChemicalStructures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StructureDataItem }
     * 
     * 
     */
    public List<StructureDataItem> getChemicalStructures() {
        if (chemicalStructures == null) {
            chemicalStructures = new ArrayList<StructureDataItem>();
        }
        return this.chemicalStructures;
    }

    /**
     * Gets the value of the databaseLinks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the databaseLinks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatabaseLinks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItem }
     * 
     * 
     */
    public List<DataItem> getDatabaseLinks() {
        if (databaseLinks == null) {
            databaseLinks = new ArrayList<DataItem>();
        }
        return this.databaseLinks;
    }

    /**
     * Gets the value of the ontologyParents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ontologyParents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOntologyParents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OntologyDataItem }
     * 
     * 
     */
    public List<OntologyDataItem> getOntologyParents() {
        if (ontologyParents == null) {
            ontologyParents = new ArrayList<OntologyDataItem>();
        }
        return this.ontologyParents;
    }

    /**
     * Gets the value of the ontologyChildren property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ontologyChildren property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOntologyChildren().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OntologyDataItem }
     * 
     * 
     */
    public List<OntologyDataItem> getOntologyChildren() {
        if (ontologyChildren == null) {
            ontologyChildren = new ArrayList<OntologyDataItem>();
        }
        return this.ontologyChildren;
    }

    /**
     * Gets the value of the generalComments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the generalComments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeneralComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommentDataItem }
     * 
     * 
     */
    public List<CommentDataItem> getGeneralComments() {
        if (generalComments == null) {
            generalComments = new ArrayList<CommentDataItem>();
        }
        return this.generalComments;
    }

}
