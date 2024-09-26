import javax.crypto.Cipher;
import java.security.*;

public class Temp1299 {
    public static void main(String[] args) throws Exception {
        // Generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        // Create a Cipher instance
        Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // Initialize the cipher in ENCRYPT_MODE with the private key
        c.init(Cipher.ENCRYPT_MODE, pair.getPrivate());

        // Message to be signed
        String message = "This is a message";
        byte[] messageBytes = message.getBytes();

        // Create a message digest
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedMessage = digest.digest(messageBytes);

        // Encrypt the digest
        byte[] signed = c.doFinal(hashedMessage);

        // Verifying
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(pair.getPublic());
        verifier.update(messageBytes);

        // Verify the signature
        boolean isVerified = verifier.verify(signed);

        System.out.println("Signature verified: " + isVerified);
    }
}