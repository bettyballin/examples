import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import java.net.URL;

public class SoapMessageSender {
    public static void main(String[] args) {
        try {
            // Create a SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnectionFactory.createConnection();

            // Create a SOAP Message Request
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapRequest = messageFactory.createMessage();

            // Your service location URL
            String serviceLocation = "http://example.com/soap/service";
            
            // Send the SOAP Request and get a response
            SOAPMessage soapMessageResponse = connection.call(soapRequest, new URL(serviceLocation));

            // Close the connection
            connection.close();

            // Process the SOAP Response
            // processSoapResponse(soapMessageResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}