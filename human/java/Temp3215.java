import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp3215 {
    public static void main(String[] args) {
        try {
            // Example private key in Base64 format for demonstration purposes
            String privateKeyBase64 = "MC4CAQAwBQYDK2VwBCIEIA9EDJ5V+9z0Z3yD3kF0I6z6pP1l2l5P2+z1i5L5kE2w";
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);

            KeyFactory keyFactory = KeyFactory.getInstance("EdDSA");
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

            System.out.println("Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}