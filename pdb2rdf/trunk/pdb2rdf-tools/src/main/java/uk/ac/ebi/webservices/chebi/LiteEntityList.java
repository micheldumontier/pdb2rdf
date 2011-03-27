
package uk.ac.ebi.webservices.chebi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LiteEntityList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiteEntityList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListElement" type="{http://www.ebi.ac.uk/webservices/chebi}LiteEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiteEntityList", propOrder = {
    "listElement"
})
public class LiteEntityList {

    @XmlElement(name = "ListElement")
    protected List<LiteEntity> listElement;

    /**
     * Gets the value of the listElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LiteEntity }
     * 
     * 
     */
    public List<LiteEntity> getListElement() {
        if (listElement == null) {
            listElement = new ArrayList<LiteEntity>();
        }
        return this.listElement;
    }

}
