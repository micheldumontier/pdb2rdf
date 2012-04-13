
package uk.ac.ebi.webservices.chebi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uk.ac.ebi.webservices.chebi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetOntologyParentsResponse_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getOntologyParentsResponse");
    private final static QName _GetOntologyChildrenResponse_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getOntologyChildrenResponse");
    private final static QName _GetAllOntologyChildrenInPath_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getAllOntologyChildrenInPath");
    private final static QName _GetStructureSearchResponse_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getStructureSearchResponse");
    private final static QName _GetStructureSearch_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getStructureSearch");
    private final static QName _GetLiteEntity_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getLiteEntity");
    private final static QName _GetCompleteEntityByListResponse_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getCompleteEntityByListResponse");
    private final static QName _GetAllOntologyChildrenInPathResponse_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getAllOntologyChildrenInPathResponse");
    private final static QName _GetCompleteEntityResponse_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getCompleteEntityResponse");
    private final static QName _GetOntologyParents_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getOntologyParents");
    private final static QName _ChebiWebServiceFault_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "ChebiWebServiceFault");
    private final static QName _GetCompleteEntityByList_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getCompleteEntityByList");
    private final static QName _GetCompleteEntity_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getCompleteEntity");
    private final static QName _GetLiteEntityResponse_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getLiteEntityResponse");
    private final static QName _GetOntologyChildren_QNAME = new QName("http://www.ebi.ac.uk/webservices/chebi", "getOntologyChildren");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uk.ac.ebi.webservices.chebi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCompleteEntity }
     * 
     */
    public GetCompleteEntity createGetCompleteEntity() {
        return new GetCompleteEntity();
    }

    /**
     * Create an instance of {@link GetLiteEntity }
     * 
     */
    public GetLiteEntity createGetLiteEntity() {
        return new GetLiteEntity();
    }

    /**
     * Create an instance of {@link ChebiWebServiceFault }
     * 
     */
    public ChebiWebServiceFault createChebiWebServiceFault() {
        return new ChebiWebServiceFault();
    }

    /**
     * Create an instance of {@link LiteEntityList }
     * 
     */
    public LiteEntityList createLiteEntityList() {
        return new LiteEntityList();
    }

    /**
     * Create an instance of {@link GetAllOntologyChildrenInPathResponse }
     * 
     */
    public GetAllOntologyChildrenInPathResponse createGetAllOntologyChildrenInPathResponse() {
        return new GetAllOntologyChildrenInPathResponse();
    }

    /**
     * Create an instance of {@link GetCompleteEntityByListResponse }
     * 
     */
    public GetCompleteEntityByListResponse createGetCompleteEntityByListResponse() {
        return new GetCompleteEntityByListResponse();
    }

    /**
     * Create an instance of {@link GetOntologyParents }
     * 
     */
    public GetOntologyParents createGetOntologyParents() {
        return new GetOntologyParents();
    }

    /**
     * Create an instance of {@link GetOntologyParentsResponse }
     * 
     */
    public GetOntologyParentsResponse createGetOntologyParentsResponse() {
        return new GetOntologyParentsResponse();
    }

    /**
     * Create an instance of {@link DataItem }
     * 
     */
    public DataItem createDataItem() {
        return new DataItem();
    }

    /**
     * Create an instance of {@link GetOntologyChildrenResponse }
     * 
     */
    public GetOntologyChildrenResponse createGetOntologyChildrenResponse() {
        return new GetOntologyChildrenResponse();
    }

    /**
     * Create an instance of {@link GetAllOntologyChildrenInPath }
     * 
     */
    public GetAllOntologyChildrenInPath createGetAllOntologyChildrenInPath() {
        return new GetAllOntologyChildrenInPath();
    }

    /**
     * Create an instance of {@link GetCompleteEntityResponse }
     * 
     */
    public GetCompleteEntityResponse createGetCompleteEntityResponse() {
        return new GetCompleteEntityResponse();
    }

    /**
     * Create an instance of {@link GetOntologyChildren }
     * 
     */
    public GetOntologyChildren createGetOntologyChildren() {
        return new GetOntologyChildren();
    }

    /**
     * Create an instance of {@link StructureDataItem }
     * 
     */
    public StructureDataItem createStructureDataItem() {
        return new StructureDataItem();
    }

    /**
     * Create an instance of {@link GetLiteEntityResponse }
     * 
     */
    public GetLiteEntityResponse createGetLiteEntityResponse() {
        return new GetLiteEntityResponse();
    }

    /**
     * Create an instance of {@link Entity }
     * 
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link LiteEntity }
     * 
     */
    public LiteEntity createLiteEntity() {
        return new LiteEntity();
    }

    /**
     * Create an instance of {@link GetStructureSearchResponse }
     * 
     */
    public GetStructureSearchResponse createGetStructureSearchResponse() {
        return new GetStructureSearchResponse();
    }

    /**
     * Create an instance of {@link CommentDataItem }
     * 
     */
    public CommentDataItem createCommentDataItem() {
        return new CommentDataItem();
    }

    /**
     * Create an instance of {@link OntologyDataItemList }
     * 
     */
    public OntologyDataItemList createOntologyDataItemList() {
        return new OntologyDataItemList();
    }

    /**
     * Create an instance of {@link GetCompleteEntityByList }
     * 
     */
    public GetCompleteEntityByList createGetCompleteEntityByList() {
        return new GetCompleteEntityByList();
    }

    /**
     * Create an instance of {@link GetStructureSearch }
     * 
     */
    public GetStructureSearch createGetStructureSearch() {
        return new GetStructureSearch();
    }

    /**
     * Create an instance of {@link OntologyDataItem }
     * 
     */
    public OntologyDataItem createOntologyDataItem() {
        return new OntologyDataItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOntologyParentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getOntologyParentsResponse")
    public JAXBElement<GetOntologyParentsResponse> createGetOntologyParentsResponse(GetOntologyParentsResponse value) {
        return new JAXBElement<GetOntologyParentsResponse>(_GetOntologyParentsResponse_QNAME, GetOntologyParentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOntologyChildrenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getOntologyChildrenResponse")
    public JAXBElement<GetOntologyChildrenResponse> createGetOntologyChildrenResponse(GetOntologyChildrenResponse value) {
        return new JAXBElement<GetOntologyChildrenResponse>(_GetOntologyChildrenResponse_QNAME, GetOntologyChildrenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOntologyChildrenInPath }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getAllOntologyChildrenInPath")
    public JAXBElement<GetAllOntologyChildrenInPath> createGetAllOntologyChildrenInPath(GetAllOntologyChildrenInPath value) {
        return new JAXBElement<GetAllOntologyChildrenInPath>(_GetAllOntologyChildrenInPath_QNAME, GetAllOntologyChildrenInPath.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLiteEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getStructureSearchResponse")
    public JAXBElement<GetLiteEntityResponse> createGetStructureSearchResponse(GetLiteEntityResponse value) {
        return new JAXBElement<GetLiteEntityResponse>(_GetStructureSearchResponse_QNAME, GetLiteEntityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStructureSearch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getStructureSearch")
    public JAXBElement<GetStructureSearch> createGetStructureSearch(GetStructureSearch value) {
        return new JAXBElement<GetStructureSearch>(_GetStructureSearch_QNAME, GetStructureSearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLiteEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getLiteEntity")
    public JAXBElement<GetLiteEntity> createGetLiteEntity(GetLiteEntity value) {
        return new JAXBElement<GetLiteEntity>(_GetLiteEntity_QNAME, GetLiteEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompleteEntityByListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getCompleteEntityByListResponse")
    public JAXBElement<GetCompleteEntityByListResponse> createGetCompleteEntityByListResponse(GetCompleteEntityByListResponse value) {
        return new JAXBElement<GetCompleteEntityByListResponse>(_GetCompleteEntityByListResponse_QNAME, GetCompleteEntityByListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOntologyChildrenInPathResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getAllOntologyChildrenInPathResponse")
    public JAXBElement<GetAllOntologyChildrenInPathResponse> createGetAllOntologyChildrenInPathResponse(GetAllOntologyChildrenInPathResponse value) {
        return new JAXBElement<GetAllOntologyChildrenInPathResponse>(_GetAllOntologyChildrenInPathResponse_QNAME, GetAllOntologyChildrenInPathResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompleteEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getCompleteEntityResponse")
    public JAXBElement<GetCompleteEntityResponse> createGetCompleteEntityResponse(GetCompleteEntityResponse value) {
        return new JAXBElement<GetCompleteEntityResponse>(_GetCompleteEntityResponse_QNAME, GetCompleteEntityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOntologyParents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getOntologyParents")
    public JAXBElement<GetOntologyParents> createGetOntologyParents(GetOntologyParents value) {
        return new JAXBElement<GetOntologyParents>(_GetOntologyParents_QNAME, GetOntologyParents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChebiWebServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "ChebiWebServiceFault")
    public JAXBElement<ChebiWebServiceFault> createChebiWebServiceFault(ChebiWebServiceFault value) {
        return new JAXBElement<ChebiWebServiceFault>(_ChebiWebServiceFault_QNAME, ChebiWebServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompleteEntityByList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getCompleteEntityByList")
    public JAXBElement<GetCompleteEntityByList> createGetCompleteEntityByList(GetCompleteEntityByList value) {
        return new JAXBElement<GetCompleteEntityByList>(_GetCompleteEntityByList_QNAME, GetCompleteEntityByList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompleteEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getCompleteEntity")
    public JAXBElement<GetCompleteEntity> createGetCompleteEntity(GetCompleteEntity value) {
        return new JAXBElement<GetCompleteEntity>(_GetCompleteEntity_QNAME, GetCompleteEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLiteEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getLiteEntityResponse")
    public JAXBElement<GetLiteEntityResponse> createGetLiteEntityResponse(GetLiteEntityResponse value) {
        return new JAXBElement<GetLiteEntityResponse>(_GetLiteEntityResponse_QNAME, GetLiteEntityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOntologyChildren }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ebi.ac.uk/webservices/chebi", name = "getOntologyChildren")
    public JAXBElement<GetOntologyChildren> createGetOntologyChildren(GetOntologyChildren value) {
        return new JAXBElement<GetOntologyChildren>(_GetOntologyChildren_QNAME, GetOntologyChildren.class, null, value);
    }

}
