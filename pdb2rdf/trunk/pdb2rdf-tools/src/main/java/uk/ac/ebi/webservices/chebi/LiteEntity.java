
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LiteEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiteEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chebiId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chebiAsciiName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="searchScore" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="entityStar" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiteEntity", propOrder = {
    "chebiId",
    "chebiAsciiName",
    "searchScore",
    "entityStar"
})
public class LiteEntity {

    @XmlElement(required = true)
    protected String chebiId;
    protected String chebiAsciiName;
    protected Float searchScore;
    protected Integer entityStar;

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
     * Gets the value of the searchScore property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSearchScore() {
        return searchScore;
    }

    /**
     * Sets the value of the searchScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSearchScore(Float value) {
        this.searchScore = value;
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

}
