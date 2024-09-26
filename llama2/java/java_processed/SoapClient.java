import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.namespace.QName;
import java.net.URL;
import java.util.Iterator;

public class SoapClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://localhost:9443/services/MyService");

        // Create a SOAPConnectionFactory
        SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();

        // Create a SOAPConnection
        SOAPConnection connection = factory.createConnection();

        // Create a SOAPMessage
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage message = messageFactory.createMessage();

        // Get the SOAPEnvelope
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();

        // Add a signature to the SOAPEnvelope
        envelope.addNamespaceDeclaration("ds", "http://www.w3.org/2000/09/xmldsig#");
        envelope.addAttribute(new QName("http://www.w3.org/2000/09/xmldsig#", "Id"), "MySignature");

        // Set up the SOAPBody
        SOAPBody body = message.getSOAPPart().getEnvelope().getBody();

        // Add a sample payload to the SOAPBody
        SOAPElement element = body.addChildElement(new QName("http://example.com", "GetLastTradePrice", "m"));
        element.addAttribute(new QName("symbol"), "AAPL");

        // Send the message and get the response
        SOAPMessage response = connection.call(message, url);

        // Print the response
        response.writeTo(System.out);

        // Close the connection
        connection.close();
    }
}