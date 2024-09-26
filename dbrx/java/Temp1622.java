import org.apache.wss4j.common.WSEncryptionPart;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.CryptoFactory;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.message.WSSecSignature;

import java.util.Properties;

public class Temp1622 {
    public static void main(String[] args) {
        try {
            // Create a new WSSecSignature instance
            WSSecSignature sign = new WSSecSignature();

            // Add Reference for Timestamp
            WSEncryptionPart encP = new WSEncryptionPart("Timestamp", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            sign.addReference(encP);

            // Add Reference for Body
            encP = new WSEncryptionPart("Body", WSConstants.URI_SOAP11_ENV);
            sign.addReference(encP, "http://www.w3.org/2000/09/xmldsig#enveloped-signature");

            // Create a Crypto instance
            Properties props = new Properties();
            props.setProperty("org.apache.wss4j.crypto.provider", "org.apache.wss4j.common.crypto.Merlin");
            props.setProperty("org.apache.wss4j.crypto.merlin.keystore.type", "JKS");
            props.setProperty("org.apache.wss4j.crypto.merlin.keystore.password", "changeit");
            props.setProperty("org.apache.wss4j.crypto.merlin.keystore.file", "cacerts");
            Crypto crypto = CryptoFactory.getInstance(props);

            // Build the signature
            sign.build(crypto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}