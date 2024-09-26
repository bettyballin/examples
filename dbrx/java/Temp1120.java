import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.WSSecHeader;
import org.apache.wss4j.dom.common.SOAPUtil;
import org.apache.wss4j.dom.message.WSSecSignature;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.Merlin;
import org.w3c.dom.Document;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Temp1120 {
    public static void main(String[] args) throws Exception {
        // Create a SOAP message
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage message = messageFactory.createMessage();

        // Insert Security Header
        WSSecHeader secHeader = new WSSecHeader();
        SOAPPart soapPart = message.getSOAPPart();
        secHeader.insertSecurityHeader(soapPart);

        // Get the document
        Document doc = soapPart.getEnvelope().getOwnerDocument();

        // Create a Crypto instance
        Properties properties = new Properties();
        properties.load(new FileInputStream("crypto.properties"));
        Crypto crypto = new Merlin(properties);

        // Build the signature
        WSSecSignature signatureBuilder = new WSSecSignature();
        signatureBuilder.setUserInfo("username", "password");
        signatureBuilder.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE);
        signatureBuilder.build(doc, crypto, secHeader);

        // Save the changes
        message.saveChanges();

        // Print the SOAP message
        try {
            message.writeTo(System.out);
        } catch (IOException e) {
            System.err.println("Error writing to output: " + e.getMessage());
        }
    }
}