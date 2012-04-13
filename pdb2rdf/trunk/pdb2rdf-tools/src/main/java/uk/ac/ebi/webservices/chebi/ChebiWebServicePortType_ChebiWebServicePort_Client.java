
package uk.ac.ebi.webservices.chebi;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.3.1
 * Fri Apr 13 10:53:49 EDT 2012
 * Generated source version: 2.3.1
 * 
 */

public final class ChebiWebServicePortType_ChebiWebServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "ChebiWebServiceService");

    private ChebiWebServicePortType_ChebiWebServicePort_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = ChebiWebServiceService.WSDL_LOCATION;
        if (args.length > 0) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ChebiWebServiceService ss = new ChebiWebServiceService(wsdlURL, SERVICE_NAME);
        ChebiWebServicePortType port = ss.getChebiWebServicePort();  
        
        {
        System.out.println("Invoking getStructureSearch...");
        java.lang.String _getStructureSearch_structure = "";
        uk.ac.ebi.webservices.chebi.StructureType _getStructureSearch_type = null;
        uk.ac.ebi.webservices.chebi.StructureSearchCategory _getStructureSearch_structureSearchCategory = null;
        int _getStructureSearch_totalResults = 0;
        float _getStructureSearch_tanimotoCutoff = 0.0f;
        try {
            uk.ac.ebi.webservices.chebi.LiteEntityList _getStructureSearch__return = port.getStructureSearch(_getStructureSearch_structure, _getStructureSearch_type, _getStructureSearch_structureSearchCategory, _getStructureSearch_totalResults, _getStructureSearch_tanimotoCutoff);
            System.out.println("getStructureSearch.result=" + _getStructureSearch__return);

        } catch (ChebiWebServiceFault_Exception e) { 
            System.out.println("Expected exception: chebiWebServiceFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getAllOntologyChildrenInPath...");
        java.lang.String _getAllOntologyChildrenInPath_chebiId = "";
        uk.ac.ebi.webservices.chebi.RelationshipType _getAllOntologyChildrenInPath_relationshipType = null;
        boolean _getAllOntologyChildrenInPath_structureOnly = false;
        try {
            uk.ac.ebi.webservices.chebi.LiteEntityList _getAllOntologyChildrenInPath__return = port.getAllOntologyChildrenInPath(_getAllOntologyChildrenInPath_chebiId, _getAllOntologyChildrenInPath_relationshipType, _getAllOntologyChildrenInPath_structureOnly);
            System.out.println("getAllOntologyChildrenInPath.result=" + _getAllOntologyChildrenInPath__return);

        } catch (ChebiWebServiceFault_Exception e) { 
            System.out.println("Expected exception: chebiWebServiceFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOntologyParents...");
        java.lang.String _getOntologyParents_chebiId = "";
        try {
            uk.ac.ebi.webservices.chebi.OntologyDataItemList _getOntologyParents__return = port.getOntologyParents(_getOntologyParents_chebiId);
            System.out.println("getOntologyParents.result=" + _getOntologyParents__return);

        } catch (ChebiWebServiceFault_Exception e) { 
            System.out.println("Expected exception: chebiWebServiceFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getCompleteEntity...");
        java.lang.String _getCompleteEntity_chebiId = "";
        try {
            uk.ac.ebi.webservices.chebi.Entity _getCompleteEntity__return = port.getCompleteEntity(_getCompleteEntity_chebiId);
            System.out.println("getCompleteEntity.result=" + _getCompleteEntity__return);

        } catch (ChebiWebServiceFault_Exception e) { 
            System.out.println("Expected exception: chebiWebServiceFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getCompleteEntityByList...");
        java.util.List<java.lang.String> _getCompleteEntityByList_listOfChEBIIds = null;
        try {
            java.util.List<uk.ac.ebi.webservices.chebi.Entity> _getCompleteEntityByList__return = port.getCompleteEntityByList(_getCompleteEntityByList_listOfChEBIIds);
            System.out.println("getCompleteEntityByList.result=" + _getCompleteEntityByList__return);

        } catch (ChebiWebServiceFault_Exception e) { 
            System.out.println("Expected exception: chebiWebServiceFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getLiteEntity...");
        java.lang.String _getLiteEntity_search = "";
        uk.ac.ebi.webservices.chebi.SearchCategory _getLiteEntity_searchCategory = null;
        int _getLiteEntity_maximumResults = 0;
        uk.ac.ebi.webservices.chebi.StarsCategory _getLiteEntity_stars = null;
        try {
            uk.ac.ebi.webservices.chebi.LiteEntityList _getLiteEntity__return = port.getLiteEntity(_getLiteEntity_search, _getLiteEntity_searchCategory, _getLiteEntity_maximumResults, _getLiteEntity_stars);
            System.out.println("getLiteEntity.result=" + _getLiteEntity__return);

        } catch (ChebiWebServiceFault_Exception e) { 
            System.out.println("Expected exception: chebiWebServiceFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOntologyChildren...");
        java.lang.String _getOntologyChildren_chebiId = "";
        try {
            uk.ac.ebi.webservices.chebi.OntologyDataItemList _getOntologyChildren__return = port.getOntologyChildren(_getOntologyChildren_chebiId);
            System.out.println("getOntologyChildren.result=" + _getOntologyChildren__return);

        } catch (ChebiWebServiceFault_Exception e) { 
            System.out.println("Expected exception: chebiWebServiceFault has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
