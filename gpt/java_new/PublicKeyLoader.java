import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class PublicKeyLoader {

    private static final String PUBLIC_KEY_PEM =
            "-----BEGIN PUBLIC KEY-----
" +
            // ... (rest of your PEM string here)
            "-----END PUBLIC KEY-----";

    public static PublicKey generatePublicKey() throws Exception {
        String base64PublicKey = PUBLIC_KEY_PEM
                .replace("-----BEGIN PUBLIC KEY-----
", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        byte[] publicKeyBytes = Base64.getDecoder().decode(base64PublicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}