import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp482 {
    public static void main(String[] args) {
        try {
            // Read the public key from the file
            File file = new File("public_key.pem");
            String key = new String(Files.readAllBytes(file.toPath()));
            
            // Remove the first and last lines
            key = key.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", "");
            
            // Decode the base64 encoded string
            byte[] pubEncoded = Base64.getDecoder().decode(key);
            
            // Generate the public key
            X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubEncoded);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PublicKey pubKey = kf.generatePublic(pubSpec);
            
            // Output the public key
            System.out.println(pubKey);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}