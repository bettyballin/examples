import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class ReadPrivateKey {
    public static PrivateKey loadPrivateKey(String filePath) throws IOException, GeneralSecurityException {
        String keyPEM = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath)));
        String privateKeyPEM = keyPEM
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");

        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        return keyFactory.generatePrivate(keySpec);
    }
}