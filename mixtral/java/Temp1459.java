import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAKeyGenParameterSpec;

public class Temp1459 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

            // Set the key size to 2048 bits and use OAEP (Optimal Asymmetric Encryption Padding)
            RSAKeyGenParameterSpec spec = new RSAKeyGenParameterSpec(2048, RSAKeyGenParameterSpec.F4);

            kpg.initialize(spec);

            KeyPair keyPair = kpg.generateKeyPair();

            // Cast the generated keys into their respective types
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            System.out.println("Public Key: " + publicKey);
            System.out.println("Private Key: " + privateKey);

        } catch (Exception e) {
            System.out.println("Error generating RSA key pair: " + e);
        }
    }
}