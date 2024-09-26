import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;

public class DiffieHellmanExample {

    public static byte[] combineKeys(PrivateKey privateKey, PublicKey publicKey) throws Exception {
        KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
        keyAgreement.init(privateKey);
        keyAgreement.doPhase(publicKey, true);
        return keyAgreement.generateSecret();
    }

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        keyPairGenerator.initialize(2048);
        KeyPair aliceKeyPair = keyPairGenerator.generateKeyPair();
        
        // Extract the generated parameters
        DHParameterSpec dhParamSpec = ((DHPublicKey) aliceKeyPair.getPublic()).getParams();
        
        // Generate Bob's key pair with Alice's parameters
        keyPairGenerator.initialize(dhParamSpec);
        KeyPair bobKeyPair = keyPairGenerator.generateKeyPair();
        
        // Alice combines her private key with Bob's public key to generate the shared secret
        byte[] aliceSharedSecret = combineKeys(aliceKeyPair.getPrivate(), bobKeyPair.getPublic());
        
        // Bob combines his private key with Alice's public key to generate the shared secret
        byte[] bobSharedSecret = combineKeys(bobKeyPair.getPrivate(), aliceKeyPair.getPublic());
        
        // Display the shared secret
        System.out.println("Alice's Shared Secret: " + new BigInteger(1, aliceSharedSecret).toString(16));
        System.out.println("Bob's Shared Secret: " + new BigInteger(1, bobSharedSecret).toString(16));
    }
}