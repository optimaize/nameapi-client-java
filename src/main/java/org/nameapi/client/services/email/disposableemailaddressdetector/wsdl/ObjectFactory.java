
package org.nameapi.client.services.email.disposableemailaddressdetector.wsdl;

import org.nameapi.client.commonwsdl.context.SoapContext;
import org.nameapi.client.commonwsdl.exception.FaultBean;
import org.nameapi.client.commonwsdl.exception.Retry;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.nameapi.client.services.email.disposableemailaddressdetector.wsdl package. 
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

    private final static QName _InternalServerErrorWebServiceException_QNAME = new QName("http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", "InternalServerErrorWebServiceException");
    private final static QName _InvalidInputWebServiceException_QNAME = new QName("http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", "InvalidInputWebServiceException");
    private final static QName _IsDisposableResponse_QNAME = new QName("http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", "isDisposableResponse");
    private final static QName _IsDisposable_QNAME = new QName("http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", "isDisposable");
    private final static QName _AccessDeniedWebServiceException_QNAME = new QName("http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", "AccessDeniedWebServiceException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.nameapi.client.services.email.disposableemailaddressdetector.wsdl
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
     * Create an instance of {@link IsDisposable }
     * 
     */
    public IsDisposable createIsDisposable() {
        return new IsDisposable();
    }

    /**
     * Create an instance of {@link IsDisposableResponse }
     * 
     */
    public IsDisposableResponse createIsDisposableResponse() {
        return new IsDisposableResponse();
    }

    /**
     * Create an instance of {@link SoapDisposableEmailAddressDetectorResult }
     * 
     */
    public SoapDisposableEmailAddressDetectorResult createSoapDisposableEmailAddressDetectorResult() {
        return new SoapDisposableEmailAddressDetectorResult();
    }

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
    @XmlElementDecl(namespace = "http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", name = "InternalServerErrorWebServiceException")
    public JAXBElement<FaultBean> createInternalServerErrorWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InternalServerErrorWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", name = "InvalidInputWebServiceException")
    public JAXBElement<FaultBean> createInvalidInputWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InvalidInputWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsDisposableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", name = "isDisposableResponse")
    public JAXBElement<IsDisposableResponse> createIsDisposableResponse(IsDisposableResponse value) {
        return new JAXBElement<IsDisposableResponse>(_IsDisposableResponse_QNAME, IsDisposableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsDisposable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", name = "isDisposable")
    public JAXBElement<IsDisposable> createIsDisposable(IsDisposable value) {
        return new JAXBElement<IsDisposable>(_IsDisposable_QNAME, IsDisposable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://disposableemailaddressdetector.email.services.v4_0.soap.server.nameapi.org/", name = "AccessDeniedWebServiceException")
    public JAXBElement<FaultBean> createAccessDeniedWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_AccessDeniedWebServiceException_QNAME, FaultBean.class, null, value);
    }

}
