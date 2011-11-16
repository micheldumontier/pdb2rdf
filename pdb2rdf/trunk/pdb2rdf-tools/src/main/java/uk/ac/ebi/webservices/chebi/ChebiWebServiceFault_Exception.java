
package uk.ac.ebi.webservices.chebi;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.3.1
 * Wed Nov 16 10:25:49 EST 2011
 * Generated source version: 2.3.1
 * 
 */

@WebFault(name = "ChebiWebServiceFault", targetNamespace = "http://www.ebi.ac.uk/webservices/chebi")
public class ChebiWebServiceFault_Exception extends Exception {
    public static final long serialVersionUID = 20111116102549L;
    
    private uk.ac.ebi.webservices.chebi.ChebiWebServiceFault chebiWebServiceFault;

    public ChebiWebServiceFault_Exception() {
        super();
    }
    
    public ChebiWebServiceFault_Exception(String message) {
        super(message);
    }
    
    public ChebiWebServiceFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public ChebiWebServiceFault_Exception(String message, uk.ac.ebi.webservices.chebi.ChebiWebServiceFault chebiWebServiceFault) {
        super(message);
        this.chebiWebServiceFault = chebiWebServiceFault;
    }

    public ChebiWebServiceFault_Exception(String message, uk.ac.ebi.webservices.chebi.ChebiWebServiceFault chebiWebServiceFault, Throwable cause) {
        super(message, cause);
        this.chebiWebServiceFault = chebiWebServiceFault;
    }

    public uk.ac.ebi.webservices.chebi.ChebiWebServiceFault getFaultInfo() {
        return this.chebiWebServiceFault;
    }
}
