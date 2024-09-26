import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecUsernameToken;

public class Temp1856 {
    public static void main(String[] args) {
        try {
            Temp1856 temp = new Temp1856();
            Node securityNode = temp.buildSecurityHeader("username", "password");
            System.out.println(securityNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Node buildSecurityHeader(String username, String password)
            throws WSSecurityException, ParserConfigurationException, SAXException, IOException {

        // XML Document builder with a root node
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inStream = new InputSource();
        inStream.setCharacterStream(new StringReader("<root></root>"));
        Document document = builder.parse(inStream);

        // <wsse:UsernameToken>
        WSSecUsernameToken usernametoken = new WSSecUsernameToken();
        usernametoken.setPasswordType(WSConstants.PASSWORD_DIGEST);
        usernametoken.setUserInfo(username, password);

        // <wsse:Security>
        WSSecHeader secHeader = new WSSecHeader(document);
        secHeader.insertSecurityHeader();

        // Generates the Document with <root><Header><wsse:Security>...
        usernametoken.build(document, secHeader);

        // Extract the desired node
        Node securityNode = document.getElementsByTagName("wsse:Security").item(0);

        return securityNode;
    }
}