import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecUsernameToken;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class SecurityHeaderBuilder {

    public Node buildSecurityHeader(String username, String password)
            throws WSSecurityException, ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inStream = new InputSource();
        inStream.setCharacterStream(new StringReader("<root></root>"));
        Document document = builder.parse(inStream);

        WSSecUsernameToken usernametoken = new WSSecUsernameToken();
        usernametoken.setPasswordType(WSConstants.PASSWORD_DIGEST);
        usernametoken.setUserInfo(username, password);

        WSSecHeader secHeader = new WSSecHeader(document);
        secHeader.insertSecurityHeader();

        usernametoken.build(document, secHeader);

        Node securityNode = document.getElementsByTagName("wsse:Security").item(0);

        return securityNode;
    }
}