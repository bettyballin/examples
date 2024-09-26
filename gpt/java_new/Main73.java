import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Main73 {
    public static PrivateKey loadPrivateKey(String filename) throws Exception {
        Path path = Paths.get(filename);
        String privateKeyContent = new String(Files.readAllBytes(path));
        privateKeyContent = privateKeyContent.replaceAll("\
", "")
                                             .replace("-----BEGIN PRIVATE KEY-----", "")
                                             .replace("-----END PRIVATE KEY-----", "");
        
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyContent));
        return kf.generatePrivate(keySpecPKCS8);
    }

    public static void main(String[] args) {
        // Example usage of loadPrivateKey method
        try {
            PrivateKey privateKey = loadPrivateKey("path/to/private/key");
            // Use the PrivateKey instance as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}