import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class Main1 {
    private static final String RSA_METHOD = "RSA";

    public static void main(String[] args) {
        File inputKeyFile = new File("private.der");

        try {
            byte[] encodedKey = Files.readAllBytes(inputKeyFile.toPath());
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
            KeyFactory keyFactory = KeyFactory.getInstance(RSA_METHOD);
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            // Use the PrivateKey for your purposes here...
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}