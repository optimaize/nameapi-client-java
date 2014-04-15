
package org.nameapi.client.services.formatter.personnameformatter.wsdl;

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
 * generated in the org.nameapi.client.services.formatter.personnameformatter.wsdl package. 
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

    private final static QName _Format_QNAME = new QName("http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", "format");
    private final static QName _InternalWebServiceException_QNAME = new QName("http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", "InternalWebServiceException");
    private final static QName _InvalidInputWebServiceException_QNAME = new QName("http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", "InvalidInputWebServiceException");
    private final static QName _FormatResponse_QNAME = new QName("http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", "formatResponse");
    private final static QName _AccessDeniedWebServiceException_QNAME = new QName("http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", "AccessDeniedWebServiceException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.nameapi.client.services.formatter.personnameformatter.wsdl
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
     * Create an instance of {@link FormatResponse }
     * 
     */
    public FormatResponse createFormatResponse() {
        return new FormatResponse();
    }

    /**
     * Create an instance of {@link Format }
     * 
     */
    public Format createFormat() {
        return new Format();
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
     * Create an instance of {@link SoapFormatterProperties }
     * 
     */
    public SoapFormatterProperties createSoapFormatterProperties() {
        return new SoapFormatterProperties();
    }

    /**
     * Create an instance of {@link SoapNameField }
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
     * Create an instance of {@link SoapFormatterResult }
     * 
     */
    public SoapFormatterResult createSoapFormatterResult() {
        return new SoapFormatterResult();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Format }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", name = "format")
    public JAXBElement<Format> createFormat(Format value) {
        return new JAXBElement<Format>(_Format_QNAME, Format.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", name = "InternalWebServiceException")
    public JAXBElement<FaultBean> createInternalWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InternalWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", name = "InvalidInputWebServiceException")
    public JAXBElement<FaultBean> createInvalidInputWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InvalidInputWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", name = "formatResponse")
    public JAXBElement<FormatResponse> createFormatResponse(FormatResponse value) {
        return new JAXBElement<FormatResponse>(_FormatResponse_QNAME, FormatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personnameformatter.formatter.services.v4_0.soap.server.nameapi.org/", name = "AccessDeniedWebServiceException")
    public JAXBElement<FaultBean> createAccessDeniedWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_AccessDeniedWebServiceException_QNAME, FaultBean.class, null, value);
    }

}
