import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class PrivateKeyLoader {

    public PrivateKey loadPrivateKey(String location) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        try (BufferedReader reader = new BufferedReader(new FileReader(location))) {
            StringBuilder privateKeyContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("PRIVATE KEY-----")) {
                    privateKeyContent.append(line.trim());
                }
            }
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyContent.toString()));
            return keyFactory.generatePrivate(keySpec);
        }
    }
}