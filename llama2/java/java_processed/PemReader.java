import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class PemReader {
    public static void main(String[] args) throws Exception {
        String pem = "-----BEGIN PUBLIC KEY-----\n" +
                "MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAE/7LW6RPu8h+k9iTp5VX1JtU2fqrN3\n" +
                "OeM1KLlNh/hHGIaC9E2dyRoYX0Fw4SsQIDAqBgkqhkiG9w0BBwAgKEQp5VX1JtU2fqrN3\n" +
                "OeM1KLlNh/hHGIaC9E2dyRoY\n" +
                "-----END PUBLIC KEY-----";

        pem = pem.replace("-----BEGIN PUBLIC KEY-----\n", "")
                 .replace("-----END PUBLIC KEY-----", "")
                 .replace("\n", "");

        byte[] decoded = Base64.getDecoder().decode(pem);

        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        System.out.println("Public Key: " + publicKey);
    }
}