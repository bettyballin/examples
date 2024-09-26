import org.apache.wss4j.dom.WSSecurityEngine;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.handler.WSHandlerResult;
import org.apache.wss4j.dom.message.WSSecHeader;
import org.apache.wss4j.dom.message.WSSecSignature;
import org.apache.wss4j.common.SignatureAlgorithm;
import org.apache.wss4j.common.crypto.WSS4JCrypto;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.w3c.dom.Document;

import java.util.List;
import java.util.Properties;

public class WSSecurityExample {
    private WSSecurityEngine secEngine = new WSSecurityEngine();
    private WSS4JCrypto crypto;
    private Properties properties;

    public WSSecurityExample() {
        properties = new Properties();
        // Set crypto properties e.g. org.apache.wss4j.crypto.provider, org.apache.wss4j.crypto.merlin.keystore.type, etc.
        // crypto = CryptoFactory.getInstance(properties);
    }

    public List<WSHandlerResult> applySecurity(Document doc) throws WSSecurityException {
        WSSecHeader secHeader = new WSSecHeader(doc);
        secHeader.insertSecurityHeader();

        WSSecSignature secSignature = new WSSecSignature();
        secSignature.setSignatureAlgorithm(SignatureAlgorithm.RSA);
        // Set other signature properties if needed, like user credentials, key identifier, etc.

        RequestData reqData = new RequestData();
        reqData.setWssConfig(secEngine.getWssConfig());
        // Set other request data properties if needed

        secSignature.build(doc, crypto, secHeader);

        return secEngine.processSecurityHeader(doc, reqData);
    }
}