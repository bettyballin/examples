import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class KeyPairToString {

    public static void main(String[] args) {
        try {
            // Generate a new key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            
            // Get the public and private keys
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            
            // Convert to Base64 encoded strings
            String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
            
            // Print the encoded keys
            System.out.println("Public Key: " + publicKeyString);
            System.out.println("Private Key: " + privateKeyString);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}