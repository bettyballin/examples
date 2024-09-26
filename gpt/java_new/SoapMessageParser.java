import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecUsernameToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class SoapMessageParser {
    public void parseSoapMessage(String request, String username, String password) throws Exception {
        // Your existing code to parse the SOAP message
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // Make sure the factory is namespace aware
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource inStream = new InputSource();
        inStream.setCharacterStream(new StringReader(request));
        Document document = builder.parse(inStream);
        
        // Create the username token
        WSSecUsernameToken usernametoken = new WSSecUsernameToken();
        usernametoken.setPasswordType(WSConstants.PASSWORD_TEXT);
        usernametoken.setUserInfo(username, password);
        
        // Find or create the security header
        WSSecHeader secHeader = new WSSecHeader(document);
        secHeader.insertSecurityHeader();
        
        Element securityElem = usernametoken.build(secHeader);
        
        // Rest of the code to handle the SOAP message
    }
}