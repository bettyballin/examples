import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import java.net.URL;

public class Temp440 {
    public static void main(String[] args) {
        try {
            // Create a SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Create a SOAP Message
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapRequest = messageFactory.createMessage();

            // Define the service URL
            String serviceLocation = "http://example.com/service"; // Replace with actual service URL

            // Call the web service
            SOAPMessage soapMessageResponse = soapConnection.call(soapRequest, new URL(serviceLocation));

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapMessageResponse.writeTo(System.out);

            // Close the connection
            soapConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}