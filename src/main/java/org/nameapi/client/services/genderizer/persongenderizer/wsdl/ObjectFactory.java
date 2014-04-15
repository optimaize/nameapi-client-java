
package org.nameapi.client.services.genderizer.persongenderizer.wsdl;

import org.nameapi.client.commonwsdl.context.SoapContext;
import org.nameapi.client.commonwsdl.exception.FaultBean;
import org.nameapi.client.commonwsdl.person.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.nameapi.client.services.genderizer.persongenderizer.wsdl package. 
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

    private final static QName _AccessDeniedWebServiceException_QNAME = new QName("http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", "AccessDeniedWebServiceException");
    private final static QName _InternalWebServiceException_QNAME = new QName("http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", "InternalWebServiceException");
    private final static QName _InvalidInputWebServiceException_QNAME = new QName("http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", "InvalidInputWebServiceException");
    private final static QName _AssessResponse_QNAME = new QName("http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", "assessResponse");
    private final static QName _Assess_QNAME = new QName("http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", "assess");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.nameapi.client.services.genderizer.persongenderizer.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SoapContext }
     * 
     */
    public SoapContext createSoapContext() {
        return new SoapContext();
    }

    /**
     * Create an instance of {@link SoapContext.Properties }
     * 
     */
    public SoapContext.Properties createSoapContextProperties() {
        return new SoapContext.Properties();
    }

    /**
     * Create an instance of {@link FaultBean }
     * 
     */
    public FaultBean createFaultBean() {
        return new FaultBean();
    }

    /**
     * Create an instance of {@link Assess }
     * 
     */
    public Assess createAssess() {
        return new Assess();
    }

    /**
     * Create an instance of {@link AssessResponse }
     * 
     */
    public AssessResponse createAssessResponse() {
        return new AssessResponse();
    }

    /**
     * Create an instance of {@link SoapSimpleNaturalPerson }
     * 
     */
    public SoapSimpleNaturalPerson createSoapSimpleNaturalPerson() {
        return new SoapSimpleNaturalPerson();
    }

    /**
     * Create an instance of {@link SoapAddress }
     * 
     */
    public SoapAddress createSoapAddress() {
        return new SoapAddress();
    }

    /**
     * Create an instance of {@link SoapPersonGenderizerResult }
     * 
     */
    public SoapPersonGenderizerResult createSoapPersonGenderizerResult() {
        return new SoapPersonGenderizerResult();
    }

    /**
     * Create an instance of {@link org.nameapi.client.commonwsdl.person.SoapNameField }
     * 
     */
    public SoapNameField createSoapNameField() {
        return new SoapNameField();
    }

    /**
     * Create an instance of {@link SoapTelNumber }
     * 
     */
    public SoapTelNumber createSoapTelNumber() {
        return new SoapTelNumber();
    }

    /**
     * Create an instance of {@link SoapStreetInfo }
     * 
     */
    public SoapStreetInfo createSoapStreetInfo() {
        return new SoapStreetInfo();
    }

    /**
     * Create an instance of {@link SoapEmailAddress }
     * 
     */
    public SoapEmailAddress createSoapEmailAddress() {
        return new SoapEmailAddress();
    }

    /**
     * Create an instance of {@link SoapPersonName }
     * 
     */
    public SoapPersonName createSoapPersonName() {
        return new SoapPersonName();
    }

    /**
     * Create an instance of {@link SoapAddressRelation }
     * 
     */
    public SoapAddressRelation createSoapAddressRelation() {
        return new SoapAddressRelation();
    }

    /**
     * Create an instance of {@link SoapAgeInfo }
     * 
     */
    public SoapAgeInfo createSoapAgeInfo() {
        return new SoapAgeInfo();
    }

//    /**
//     * Create an instance of {@link Retry }
//     *
//     */
//    public Retry createRetry() {
//        return new Retry();
//    }

    /**
     * Create an instance of {@link SoapContext.Properties.Entry }
     * 
     */
    public SoapContext.Properties.Entry createSoapContextPropertiesEntry() {
        return new SoapContext.Properties.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", name = "AccessDeniedWebServiceException")
    public JAXBElement<FaultBean> createAccessDeniedWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_AccessDeniedWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", name = "InternalWebServiceException")
    public JAXBElement<FaultBean> createInternalWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InternalWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", name = "InvalidInputWebServiceException")
    public JAXBElement<FaultBean> createInvalidInputWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InvalidInputWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", name = "assessResponse")
    public JAXBElement<AssessResponse> createAssessResponse(AssessResponse value) {
        return new JAXBElement<AssessResponse>(_AssessResponse_QNAME, AssessResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Assess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://persongenderizer.genderizer.services.v4_0.soap.server.nameapi.org/", name = "assess")
    public JAXBElement<Assess> createAssess(Assess value) {
        return new JAXBElement<Assess>(_Assess_QNAME, Assess.class, null, value);
    }

}
