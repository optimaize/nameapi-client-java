
package org.nameapi.client.services.email.emaildomaintypeclassifier.wsdl;

import org.nameapi.client.commonwsdl.context.SoapContext;
import org.nameapi.client.commonwsdl.exception.FaultBean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.nameapi.client.services.email.emaildomaintypeclassifier.wsdl package. 
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

    private final static QName _ClassifyResponse_QNAME = new QName("http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", "classifyResponse");
    private final static QName _InternalServerErrorWebServiceException_QNAME = new QName("http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", "InternalServerErrorWebServiceException");
    private final static QName _InvalidInputWebServiceException_QNAME = new QName("http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", "InvalidInputWebServiceException");
    private final static QName _AccessDeniedWebServiceException_QNAME = new QName("http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", "AccessDeniedWebServiceException");
    private final static QName _Classify_QNAME = new QName("http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", "classify");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.nameapi.client.services.email.emaildomaintypeclassifier.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link org.nameapi.client.commonwsdl.context.SoapContext }
     * 
     */
    public SoapContext createSoapSimpleContext() {
        return new SoapContext();
    }

    /**
     * Create an instance of {@link org.nameapi.client.commonwsdl.context.SoapContext.Properties }
     * 
     */
    public SoapContext.Properties createSoapSimpleContextProperties() {
        return new SoapContext.Properties();
    }

    /**
     * Create an instance of {@link Classify }
     * 
     */
    public Classify createClassify() {
        return new Classify();
    }

    /**
     * Create an instance of {@link FaultBean }
     * 
     */
    public FaultBean createFaultBean() {
        return new FaultBean();
    }


    /**
     * Create an instance of {@link ClassifyResponse }
     * 
     */
    public ClassifyResponse createClassifyResponse() {
        return new ClassifyResponse();
    }

    /**
     * Create an instance of {@link org.nameapi.client.commonwsdl.context.SoapContext.Properties.Entry }
     * 
     */
    public SoapContext.Properties.Entry createSoapSimpleContextPropertiesEntry() {
        return new SoapContext.Properties.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", name = "classifyResponse")
    public JAXBElement<ClassifyResponse> createClassifyResponse(ClassifyResponse value) {
        return new JAXBElement<ClassifyResponse>(_ClassifyResponse_QNAME, ClassifyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", name = "InternalServerErrorWebServiceException")
    public JAXBElement<FaultBean> createInternalServerErrorWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InternalServerErrorWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", name = "InvalidInputWebServiceException")
    public JAXBElement<FaultBean> createInvalidInputWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InvalidInputWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", name = "AccessDeniedWebServiceException")
    public JAXBElement<FaultBean> createAccessDeniedWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_AccessDeniedWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Classify }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://emaildomaintypeclassifier.email.services.v4_0.soap.server.nameapi.org/", name = "classify")
    public JAXBElement<Classify> createClassify(Classify value) {
        return new JAXBElement<Classify>(_Classify_QNAME, Classify.class, null, value);
    }



}
