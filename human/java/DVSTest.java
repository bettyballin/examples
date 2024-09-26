package dvstest;

import dvs.common._2014._06.contract.data.Gender;
import dvs.common._2014._06.contract.data.RegistrationState;
import dvs.common._2014._06.contract.data.manager.*;
import dvs.common._2014._06.contract.service.manager.IVerification;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DVSTest {

    public static void main(String[] args) {
        try {
            System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(IVerification.class);
            factory.setAddress("https://urlhere/Https");
            factory.setBindingId("http://schemas.xmlsoap.org/wsdl/soap12/");
            factory.getFeatures().add(new WSAddressingFeature());

            IVerification port = (IVerification) factory.create();
            Client client = ClientProxy.getClient(port);

            HTTPConduit http = (HTTPConduit) client.getConduit();
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setContentType("application/soap+xml");
            http.setClient(httpClientPolicy);

            Endpoint cxfEndpoint = client.getEndpoint();

            Map<String, Object> outProps = new HashMap<>();
            outProps.put(WSHandlerConstants.ACTION, "Signature Timestamp");
            outProps.put(WSHandlerConstants.USER, "myalias");
            outProps.put(WSHandlerConstants.SIG_PROP_FILE, "client_sign.properties");
            outProps.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
            outProps.put(WSHandlerConstants.SIGNATURE_PARTS, "{Element}{http://www.w3.org/2005/08/addressing}To");
            outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
            outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientPasswordCallback.class.getName());

            WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
            cxfEndpoint.getOutInterceptors().add(wssOut);

            System.out.println(passportRequest(port).getVerificationResultCode());
            System.out.println(driverLicenseRequest(port).getVerificationResultCode());

        } catch (Exception ex) {
            Logger.getLogger(DVSTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static VerificationResponse passportRequest(IVerification port) throws Exception {
        PassportRequest request = new PassportRequest();
        DVSDate date = new DVSDate();
        date.setDay(1);
        date.setMonth(1);
        date.setYear(2017);
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<DVSDate> documentRequest = objectFactory.createDVSDate(date);
        request.setBirthDate(documentRequest);

        request.setDocumentTypeCode(DocumentType.PP);
        JAXBElement<String> familyName = objectFactory.createCertificateRequestFamilyName2("D");
        request.setFamilyName(familyName);
        JAXBElement<String> givenName = objectFactory.createCertificateRequestGivenName2("T");
        request.setGivenName(givenName);
        request.setOriginatingAgencyCode("1");
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date(System.currentTimeMillis()));
        XMLGregorianCalendar requestDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        request.setRequestDateTime(requestDate);
        request.setVerificationRequestNumber("1");
        request.setVersionNumber("1");
        JAXBElement<Gender> gender = objectFactory.createPassportRequestGender(Gender.M);
        request.setGender(gender);
        request.setTravel