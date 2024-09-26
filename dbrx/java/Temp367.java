import org.apache.commons.codec.binary.Base64;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class Temp367 {
    public static void main(String[] args) {
        try {
            // Read the content of your public_key.pem file, remove BEGIN/END lines, and convert it to byte array
            String keyPath = "path_to_your_public_key.pem";
            String keyContent = new String(Files.readAllBytes(Paths.get(keyPath)));
            keyContent = keyContent.replaceAll("-----BEGIN PUBLIC KEY-----", "")
                                    .replaceAll("-----END PUBLIC KEY-----", "")
                                    .replaceAll("\\s", "");
            
            byte[] pubEncoded = Base64.decodeBase64(keyContent.getBytes("UTF-8"));

            // Decode base64 string into a byte array
            X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubEncoded);
            KeyFactory kf = KeyFactory.getInstance("RSA"); // use the correct algorithm here
            PublicKey pubKey = kf.generatePublic(pubSpec);

            // Now you can use pubKey as needed
            System.out.println("Public Key: " + pubKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}