import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.security.interfaces.RSAPublicKey;

public class PublicKeyConverter1 {

    public static RSAPublicKey convertToRSAPublicKey(byte[] publicKeyEncoded) throws Exception {
        // Get KeyFactory for RSA
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        // Convert the public key bytes to X509EncodedKeySpec
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyEncoded);

        // Generate the RSAPublicKey from the X509EncodedKeySpec
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);

        return rsaPublicKey;
    }

    public static void main(String[] args) {
        try {
            // Assuming you have a public key in byte array (SubjectPublicKeyInfo format)
            byte[] publicKeyEncoded = {/* public key bytes */};

            RSAPublicKey rsaPublicKey = convertToRSAPublicKey(publicKeyEncoded);
            // RSAPublicKey operations...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}