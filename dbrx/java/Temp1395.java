import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp1395 {
    public static void main(String[] args) {
        try {
            PrivateKey privateKey = loadPrivateKey("private_key.pem");
            System.out.println(privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PrivateKey loadPrivateKey(String filename) throws Exception {
        String privateKeyContent = new String(Files.readAllBytes(Paths.get(Thread.currentThread().getContextClassLoader().getResource(filename).toURI())));
        // Remove line breaks and headers/footers from the private key content
        privateKeyContent = privateKeyContent.replaceAll("\\r?\\n", "").replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "");

        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(privateKeyContent));

        PrivateKey privKey = kf.generatePrivate(keySpecPKCS8);
        return privKey;
    }
}