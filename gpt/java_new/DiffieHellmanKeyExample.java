import java.security.*;
import java.security.spec.*;

public class DiffieHellmanKeyExample {

    public static void main(String[] args) throws Exception {
        // Initialize the KeyPairGenerator
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
        kpg.initialize(2048); // Consider using a larger key size for better security
        
        // Generate the Diffie-Hellman key pair
        KeyPair keyPair = kpg.generateKeyPair();

        // Extract the public key
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("Public Key: " + publicKey.toString());
        
        // Extract the private key
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("Private Key: " + privateKey.toString());
    }
}