
package org.nameapi.client.services.validator.famouspersondetector.wsdl;

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
 * generated in the org.nameapi.client.services.validator.famouspersondetector.wsdl package. 
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

    private final static QName _InternalServerErrorWebServiceException_QNAME = new QName("http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", "InternalServerErrorWebServiceException");
    private final static QName _InvalidInputWebServiceException_QNAME = new QName("http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", "InvalidInputWebServiceException");
    private final static QName _AccessDeniedWebServiceException_QNAME = new QName("http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", "AccessDeniedWebServiceException");
    private final static QName _CheckPerson_QNAME = new QName("http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", "checkPerson");
    private final static QName _CheckPersonResponse_QNAME = new QName("http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", "checkPersonResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.nameapi.client.services.validator.famouspersondetector.wsdl
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
     * Create an instance of {@link FaultBean }
     * 
     */
    public FaultBean createFaultBean() {
        return new FaultBean();
    }



    /**
     * Create an instance of {@link CheckPersonResponse }
     * 
     */
    public CheckPersonResponse createCheckPersonResponse() {
        return new CheckPersonResponse();
    }

    /**
     * Create an instance of {@link CheckPerson }
     * 
     */
    public CheckPerson createCheckPerson() {
        return new CheckPerson();
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
     * Create an instance of {@link SoapTelNumber }
     * 
     */
    public SoapTelNumber createSoapTelNumber() {
        return new SoapTelNumber();
    }

    /**
     * Create an instance of {@link SoapFamousPersonResult }
     * 
     */
    public SoapFamousPersonResult createSoapFamousPersonResult() {
        return new SoapFamousPersonResult();
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
     * Create an instance of {@link SoapWesternPersonNameSet }
     * 
     */
    public SoapWesternPersonNameSet createSoapWesternPersonNameSet() {
        return new SoapWesternPersonNameSet();
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

    /**
     * Create an instance of {@link org.nameapi.client.commonwsdl.context.SoapContext.Properties.Entry }
     * 
     */
    public SoapContext.Properties.Entry createSoapSimpleContextPropertiesEntry() {
        return new SoapContext.Properties.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", name = "InternalServerErrorWebServiceException")
    public JAXBElement<FaultBean> createInternalServerErrorWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InternalServerErrorWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", name = "InvalidInputWebServiceException")
    public JAXBElement<FaultBean> createInvalidInputWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InvalidInputWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", name = "AccessDeniedWebServiceException")
    public JAXBElement<FaultBean> createAccessDeniedWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_AccessDeniedWebServiceException_QNAME, FaultBean.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", name = "checkPerson")
    public JAXBElement<CheckPerson> createCheckPerson(CheckPerson value) {
        return new JAXBElement<CheckPerson>(_CheckPerson_QNAME, CheckPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://famouspersondetector.validator.services.v4_0.soap.server.nameapi.org/", name = "checkPersonResponse")
    public JAXBElement<CheckPersonResponse> createCheckPersonResponse(CheckPersonResponse value) {
        return new JAXBElement<CheckPersonResponse>(_CheckPersonResponse_QNAME, CheckPersonResponse.class, null, value);
    }

}
