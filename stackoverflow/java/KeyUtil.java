import java.security.KeyStore;
import java.security.interfaces.RSAPublicKey;

public class KeyUtil {
    private static KeyStore keystore; // Assuming keystore is initialized somewhere

    public static byte[] getPublicKey() { 
        try {                
            RSAPublicKey key = (RSAPublicKey)keystore.getCertificate("alias").getPublicKey();    
            return key.getEncoded();
        } catch (Exception e) {
            // Handle exception or log it
        }
        return null;
    }
}