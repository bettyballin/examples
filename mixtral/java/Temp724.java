import java.security.*;
import java.util.Base64;

public class Temp724 {
    public static void main(String[] args) throws Exception {
        // Generate a key pair for testing
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        
        String message = "Hello, World!";
        
        // Sign the message
        byte[] signedMessage = sign(message, keyPair.getPrivate());
        
        // Verify the signature
        boolean isVerified = verifySignature(message, keyPair.getPublic(), signedMessage);
        
        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signedMessage));
        System.out.println("Is signature verified: " + isVerified);
    }

    public static byte[] sign(String message, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);

        // Update and sign the data
        signature.update(message.getBytes());

        return signature.sign();
    }

    public static boolean verifySignature(String message, PublicKey publicKey, byte[] signedData) throws Exception {
        Signature sig = Signature.getInstance("SHA256withRSA");

        // Initialize the verifier
        sig.initVerify(publicKey);

        // Update and Verify
        sig.update(message.getBytes());

        return sig.verify(signedData);
    }
}