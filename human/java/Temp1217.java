import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1217 {
    public static void main(String[] args) {
        try {
            // Sample base64 encoded public and private keys
            String serialized_public_key = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE5Af0E1yQ1N2uC8t9D5Fpc6z0I6Bj0j0s6UYPuC0ZXinBd0YzY5Y4U5g0R8U1gqJhH5MxX7Qk1SgU5xFfN9kJgw==";
            String serialized_private_key = "MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgnoVnY9sF1R3vOQqAKoc5Z7KrW2X9uX7MxUu4YxD3q1uhRANCAAQ5Af0E1yQ1N2uC8t9D5Fpc6z0I6Bj0j0s6UYPuC0ZXinBd0YzY5Y4U5g0R8U1gqJhH5MxX7Qk1SgU5xFfN9kJgw==";

            // Decode the base64 encoded keys to byte arrays
            byte[] encoded_public_key = Base64.getDecoder().decode(serialized_public_key);
            byte[] encoded_private_key = Base64.getDecoder().decode(serialized_private_key);

            // If key is private, use PKCS #8
            PKCS8EncodedKeySpec formatted_private = new PKCS8EncodedKeySpec(encoded_private_key);

            // or, if key is public, use X.509
            X509EncodedKeySpec formatted_public = new X509EncodedKeySpec(encoded_public_key);

            // Retrieve key using KeyFactory
            KeyFactory kf = KeyFactory.getInstance("EC");

            PublicKey pub = kf.generatePublic(formatted_public);
            PrivateKey priv = kf.generatePrivate(formatted_private);

            System.out.println("Public Key: " + pub);
            System.out.println("Private Key: " + priv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}