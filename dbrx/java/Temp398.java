Here is the corrected Java code:


import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecUsernameToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class Temp398 {
    public static void main(String[] args) {
        try {
            // Create an empty XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Create a WSSecHeader
            WSSecHeader secHeader = new WSSecHeader(document);
            secHeader.insertSecurityHeader();

            // Create a WSSecUsernameToken
            WSSecUsernameToken usernameToken = new WSSecUsernameToken();
            usernameToken.setPasswordType(WSConstants.PASSWORD_TEXT);
            usernameToken.setUserInfo("your-username", "your-password");

            // Add the UsernameToken to the SOAP Header
            usernameToken.prepare(document);
            Element securityHeaderElement = secHeader.getSecurityHeader();
            securityHeaderElement.appendChild(usernameToken.getElement());

            // Print the resulting document for verification
            System.out.println("Generated SOAP Header with UsernameToken:");
            printDocument(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method to print the XML document
    private static void printDocument(Document doc) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");

        DOMSource domSource = new DOMSource(doc);
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        transformer.transform(domSource, sr);
        System.out.println(sw.toString());
    }
}