
package org.nameapi.client.services.validator.randomtyping.surnamerandomtypingdetector.wsdl;

import org.nameapi.client.commonwsdl.context.SoapContext;
import org.nameapi.client.commonwsdl.exception.FaultBean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.nameapi.client.services.validator.randomtyping.surnamerandomtypingdetector.wsdl package. 
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

    private final static QName _InternalServerErrorWebServiceException_QNAME = new QName("http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", "InternalServerErrorWebServiceException");
    private final static QName _InvalidInputWebServiceException_QNAME = new QName("http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", "InvalidInputWebServiceException");
    private final static QName _CheckField_QNAME = new QName("http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", "checkField");
    private final static QName _AccessDeniedWebServiceException_QNAME = new QName("http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", "AccessDeniedWebServiceException");
    private final static QName _CheckFieldResponse_QNAME = new QName("http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", "checkFieldResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.nameapi.client.services.validator.randomtyping.surnamerandomtypingdetector.wsdl
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
     * Create an instance of {@link CheckFieldResponse }
     * 
     */
    public CheckFieldResponse createCheckFieldResponse() {
        return new CheckFieldResponse();
    }

    /**
     * Create an instance of {@link CheckField }
     * 
     */
    public CheckField createCheckField() {
        return new CheckField();
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
    @XmlElementDecl(namespace = "http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", name = "InternalServerErrorWebServiceException")
    public JAXBElement<FaultBean> createInternalServerErrorWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InternalServerErrorWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", name = "InvalidInputWebServiceException")
    public JAXBElement<FaultBean> createInvalidInputWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_InvalidInputWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckField }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", name = "checkField")
    public JAXBElement<CheckField> createCheckField(CheckField value) {
        return new JAXBElement<CheckField>(_CheckField_QNAME, CheckField.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", name = "AccessDeniedWebServiceException")
    public JAXBElement<FaultBean> createAccessDeniedWebServiceException(FaultBean value) {
        return new JAXBElement<FaultBean>(_AccessDeniedWebServiceException_QNAME, FaultBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckFieldResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://randomtyping.validator.services.v4_0.soap.server.nameapi.org/", name = "checkFieldResponse")
    public JAXBElement<CheckFieldResponse> createCheckFieldResponse(CheckFieldResponse value) {
        return new JAXBElement<CheckFieldResponse>(_CheckFieldResponse_QNAME, CheckFieldResponse.class, null, value);
    }


}
