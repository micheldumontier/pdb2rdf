
package uk.ac.ebi.webservices.chebi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCompleteEntityByList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCompleteEntityByList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListOfChEBIIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="50" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCompleteEntityByList", propOrder = {
    "listOfChEBIIds"
})
public class GetCompleteEntityByList {

    @XmlElement(name = "ListOfChEBIIds")
    protected List<String> listOfChEBIIds;

    /**
     * Gets the value of the listOfChEBIIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listOfChEBIIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfChEBIIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getListOfChEBIIds() {
        if (listOfChEBIIds == null) {
            listOfChEBIIds = new ArrayList<String>();
        }
        return this.listOfChEBIIds;
    }

}
