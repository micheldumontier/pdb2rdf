
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getLiteEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getLiteEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="search" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="searchCategory" type="{http://www.ebi.ac.uk/webservices/chebi}SearchCategory"/>
 *         &lt;element name="maximumResults" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stars" type="{http://www.ebi.ac.uk/webservices/chebi}StarsCategory"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLiteEntity", propOrder = {
    "search",
    "searchCategory",
    "maximumResults",
    "stars"
})
public class GetLiteEntity {

    @XmlElement(required = true)
    protected String search;
    @XmlElement(required = true)
    protected SearchCategory searchCategory;
    protected int maximumResults;
    @XmlElement(required = true)
    protected StarsCategory stars;

    /**
     * Gets the value of the search property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearch() {
        return search;
    }

    /**
     * Sets the value of the search property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearch(String value) {
        this.search = value;
    }

    /**
     * Gets the value of the searchCategory property.
     * 
     * @return
     *     possible object is
     *     {@link SearchCategory }
     *     
     */
    public SearchCategory getSearchCategory() {
        return searchCategory;
    }

    /**
     * Sets the value of the searchCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCategory }
     *     
     */
    public void setSearchCategory(SearchCategory value) {
        this.searchCategory = value;
    }

    /**
     * Gets the value of the maximumResults property.
     * 
     */
    public int getMaximumResults() {
        return maximumResults;
    }

    /**
     * Sets the value of the maximumResults property.
     * 
     */
    public void setMaximumResults(int value) {
        this.maximumResults = value;
    }

    /**
     * Gets the value of the stars property.
     * 
     * @return
     *     possible object is
     *     {@link StarsCategory }
     *     
     */
    public StarsCategory getStars() {
        return stars;
    }

    /**
     * Sets the value of the stars property.
     * 
     * @param value
     *     allowed object is
     *     {@link StarsCategory }
     *     
     */
    public void setStars(StarsCategory value) {
        this.stars = value;
    }

}
