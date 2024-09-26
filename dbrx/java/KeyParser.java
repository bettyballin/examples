import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class KeyParser {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public PrivateKey parseECPrivateKey(String pemEncoded) throws Exception {
        // Remove the BEGIN/END lines and any whitespace
        String privateKeyPEM = pemEncoded.replace("-----BEGIN EC PRIVATE KEY-----", "")
                .replace("-----END EC PRIVATE KEY-----", "").replaceAll("\\s", "");

        byte[] encodedKey = Base64.getDecoder().decode(privateKeyPEM);

        KeyFactory keyFactory = KeyFactory.getInstance("EC", "BC");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));

        return privateKey;
    }

    public static void main(String[] args) {
        try {
            KeyParser parser = new KeyParser();
            String pem = "-----BEGIN EC PRIVATE KEY-----\n" +
                         "MHcCAQEEIAwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                         "oUQDQgAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                         "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                         "AAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
                         "-----END EC PRIVATE KEY-----";
            PrivateKey privateKey = parser.parseECPrivateKey(pem);
            System.out.println("Private Key: " + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}