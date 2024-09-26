import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Temp1331 {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();

            // Print the public key
            System.out.println("-----BEGIN PUBLIC KEY-----");
            String publicKeyBase64 = new String(Base64.getMimeEncoder().encode(keyPair.getPublic().getEncoded()));
            System.out.println(publicKeyBase64);
            System.out.println("-----END PUBLIC KEY-----");

            // Print the private key
            System.out.println("-----BEGIN PRIVATE KEY-----");
            String privateKeyBase64 = new String(Base64.getMimeEncoder().encode(keyPair.getPrivate().getEncoded()));
            System.out.println(privateKeyBase64);
            System.out.println("-----END PRIVATE KEY-----");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}