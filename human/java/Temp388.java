import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp388 {
    public static void main(String[] args) {
        try {
            String tokenString = "yourTokenString";
            String storePassword = "yourStorePassword";
            String privateKeyFile = "path/to/your/privateKeyFile";

            // Load private key from file
            byte[] keyBytes = Files.readAllBytes(Paths.get(privateKeyFile));
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("DSA");
            PrivateKey privateKey = kf.generatePrivate(spec);

            // Sign the token string
            Signature sig = Signature.getInstance("SHA1withDSA");
            sig.initSign(privateKey);
            sig.update(tokenString.getBytes());
            byte[] signedBytes = sig.sign();

            // Encode the signed bytes to Base64
            String tokensigned = Base64.getEncoder().encodeToString(signedBytes);
            System.out.println(tokensigned);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}