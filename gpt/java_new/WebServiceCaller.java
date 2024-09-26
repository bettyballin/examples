import javax.xml.soap.*;
import java.security.SecureRandom;
import java.util.Base64;

public class WebServiceCaller {

    public void callWebService() throws Exception {
        // Generate a random nonce
        SecureRandom random = new SecureRandom();
        byte[] nonceBytes = new byte[16];
        random.nextBytes(nonceBytes);
        String nonce = Base64.getEncoder().encodeToString(nonceBytes);

        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Create SOAP Message
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        // ... SOAP message creation and manipulation code goes here ...

        // Send SOAP Message to SOAP Server
        String url = "http://example.com/soap";
        SOAPMessage response = soapConnection.call(soapMessage, url);

        // Process the SOAP Response
        // ... Response processing code goes here ...

        soapConnection.close();
    }

    public static void main(String args[]) {
        WebServiceCaller caller = new WebServiceCaller();
        try {
            caller.callWebService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}