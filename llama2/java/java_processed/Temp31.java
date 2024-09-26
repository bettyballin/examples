import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

public class Temp31 {
    public static void main(String[] args) {
        Map<String, Object> signingProps = new HashMap<>();
        Map<String, Object> keyStoreProps = new HashMap<>();
        
        // Example properties. You should replace these with actual values.
        signingProps.put("action", "Signature");
        signingProps.put("user", "myAlias");
        signingProps.put("passwordCallbackClass", "com.example.PasswordCallbackHandler");
        signingProps.put("signaturePropFile", "client_sign.properties");
        
        keyStoreProps.put("org.apache.ws.security.crypto.merlin.keystore.type", "jks");
        keyStoreProps.put("org.apache.ws.security.crypto.merlin.keystore.password", "password");
        keyStoreProps.put("org.apache.ws.security.crypto.merlin.keystore.alias", "myAlias");
        keyStoreProps.put("org.apache.ws.security.crypto.merlin.keystore.file", "myKeystore.jks");

        WSS4JOutInterceptor outSigner = new WSS4JOutInterceptor(signingProps);
        outSigner.setProperty("properties", keyStoreProps);
    }
}