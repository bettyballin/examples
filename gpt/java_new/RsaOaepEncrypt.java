import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class RsaOaepEncrypt {
    public static void main(String[] args) throws Exception {
        // Generate an RSA key pair for testing
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();

        // Message to be encrypted
        byte[] message = "Hello, World!".getBytes();

        // Custom label (P value) to be used in OAEP
        byte[] label = "CustomLabel".getBytes();

        // Set up OAEP parameters with the custom label
        OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, new PSource.PSpecified(label));

        // Initialize the Cipher with the public key and OAEP parameters
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey, oaepParams);

        // Perform encryption
        byte[] cipherText = cipher.doFinal(message);

        // Output the encrypted data
        System.out.println("Encrypted message: " + java.util.Base64.getEncoder().encodeToString(cipherText));
    }
}