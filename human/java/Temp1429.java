import java.security.*;

public class Temp1429 {
    public static void main(String[] args) {
        try {
            // Generate a key pair for signing
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey priv = pair.getPrivate();
            PublicKey pub = pair.getPublic();
            
            // Create a Signature object and initialize it with the private key
            Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
            sig.initSign(priv);
            
            // Update the data to be signed
            byte[] test = {0x01, 0x02, 0x04, 0x05, 0x06, 0x07};
            sig.update(test);
            
            // Sign the data
            byte[] sigBytes = sig.sign();
            
            // Verify the signature with the public key
            sig.initVerify(pub);
            sig.update(test);
            boolean verifies = sig.verify(sigBytes);
            
            System.out.println("Signature verifies: " + verifies);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}