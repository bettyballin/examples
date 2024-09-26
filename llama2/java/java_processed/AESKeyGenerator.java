import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class AESKeyGenerator {
    public static void main(String[] args) throws Exception {
        // Test input byte array
        byte[] secret = new byte[1024];
        // Fill the secret array with some data for demonstration purposes
        new SecureRandom().nextBytes(secret);

        // Derive an AES-256 bit key from the secret
        Key aesKey = generateAESKey(secret);

        System.out.println("Generated AES key: ");
        for (int i = 0; i < aesKey.getEncoded().length; i++) {
            System.out.print(aesKey.getEncoded()[i] + " ");
        }
    }

    public static Key generateAESKey(byte[] secret) throws Exception {
        // Use a key derivation function to derive the AES key from the secret
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = sha.digest(secret);

        // Use the first 32 bytes (256 bits) for the AES key
        return new SecretKeySpec(key, 0, 32, "AES");
    }
}