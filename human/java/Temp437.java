import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import java.net.URL;

public class Temp437 {
    public static void main(String[] args) {
        try {
            // Create a SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Create a SOAP Request
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapRequest = messageFactory.createMessage();

            // Define the service location
            String serviceLocation = "http://example.com/soap-endpoint";

            // Send SOAP Message to SOAP Server
            SOAPMessage soapMessageResponse = soapConnection.call(soapRequest, new URL(serviceLocation));

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapMessageResponse.writeTo(System.out);
            System.out.println();

            // Close the SOAP Connection
            soapConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}