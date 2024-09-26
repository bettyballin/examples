import java.security.*;
import java.io.IOException;
import java.security.spec.X509EncodedKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Temp504 {
    public static void main(String[] args) {
        // Example usage - replace with a valid Base64 encoded public key string
        String base64PublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuK2JmjkK+2dB6ZkR9mXb";
        try {
            PublicKey publicKey = loadPublicKey(base64PublicKey);
            System.out.println("Public key loaded successfully: " + publicKey);
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public static PublicKey loadPublicKey(String stored) throws GeneralSecurityException, IOException {
        byte[] data = DatatypeConverter.parseBase64Binary(stored);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        return fact.generatePublic(spec);
    }
}