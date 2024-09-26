import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.StringWriter;

public class SecurityHeaderCreator {

    public static void main(String[] args) {
        String username = "user";
        String password = "pass";
        String securityHeader = nodeToString(buildSecurityHeader(username, password));
        System.out.println(securityHeader);
    }

    private static Element buildSecurityHeader(String username, String password) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Create security header element
            Element securityHeader = doc.createElement("SecurityHeader");
            Element userElement = doc.createElement("Username");
            userElement.appendChild(doc.createTextNode(username));
            Element passElement = doc.createElement("Password");
            passElement.appendChild(doc.createTextNode(password));
            securityHeader.appendChild(userElement);
            securityHeader.appendChild(passElement);

            return securityHeader;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String nodeToString(Element node) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(node), new StreamResult(sw));
            return sw.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}