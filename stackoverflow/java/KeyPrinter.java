import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

public class KeyPrinter {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();

            String publicKeyBase64 = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
            String privateKeyBase64 = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());

            System.out.println("-----BEGIN PUBLIC KEY-----");
            System.out.println(publicKeyBase64);
            System.out.println("-----END PUBLIC KEY-----");
            System.out.println("-----BEGIN PRIVATE KEY-----");
            System.out.println(privateKeyBase64);
            System.out.println("-----END PRIVATE KEY-----");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}