
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllOntologyChildrenInPathResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllOntologyChildrenInPathResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.ebi.ac.uk/webservices/chebi}OntologyDataItemList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllOntologyChildrenInPathResponse", propOrder = {
    "_return"
})
public class GetAllOntologyChildrenInPathResponse {

    @XmlElement(name = "return", required = true)
    protected OntologyDataItemList _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link OntologyDataItemList }
     *     
     */
    public OntologyDataItemList getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link OntologyDataItemList }
     *     
     */
    public void setReturn(OntologyDataItemList value) {
        this._return = value;
    }

}
