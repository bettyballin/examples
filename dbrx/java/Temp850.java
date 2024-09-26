import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.common.crypto.Merlin;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.engine.WSSConfig;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.dom.message.WSSecEncrypt;
import org.apache.wss4j.dom.util.WSSecurityUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Properties;

public class Temp850 {
    public static void main(String[] args) throws Exception {

        // Initialize the document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("input.xml")); // Replace with your XML file

        // Initialize WSS4J config
        WSSConfig.init();

        // Initialize WSSecHeader
        WSSecHeader secHeader = new WSSecHeader();
        secHeader.insertSecurityHeader(doc);

        String xpathExpression = "//xxx/yyy";
        QName qname = new QName("http://example.com", "yyy");

        // Initialize the WSSecEncrypt builder
        WSSecEncrypt encryptBuilder = new WSSecEncrypt();
        encryptBuilder.setUserInfo("myAlias"); // Replace with your alias
        encryptBuilder.setSymmetricEncAlgorithm(WSConstants.AES_128);
        encryptBuilder.setKeyIdentifierType(WSConstants.ISSUER_SERIAL);

        // Load the crypto properties
        Properties cryptoProperties = new Properties();
        cryptoProperties.load(Temp850.class.getResourceAsStream("/crypto.properties"));

        Merlin crypto = new Merlin(cryptoProperties, Temp850.class.getClassLoader());

        // Build the encrypted document
        encryptBuilder.build(doc, crypto, secHeader);
    }
}