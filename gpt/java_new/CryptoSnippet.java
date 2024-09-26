import java.security.*;
import javax.crypto.Cipher;

public class CryptoSnippet {

    public static void main(String[] args) {
        try {
            // Assuming 'hash', 'privKey', and 'pubKey' are initialized properly.
            MessageDigest hash = MessageDigest.getInstance("SHA-256");
            PrivateKey privKey = null; // Initialize with actual private key
            PublicKey pubKey = null; // Initialize with actual public key
            Cipher cipher = Cipher.getInstance("RSA");

            // Compute the hash once and store it
            byte[] hashValue = hash.digest("YourStringToHash".getBytes());

            // Convert to hex string for printing
            System.out.println("digest : " + toHex(hashValue));

            // Encrypt
            cipher.init(Cipher.ENCRYPT_MODE, privKey);
            byte[] ciphertext = cipher.doFinal(hashValue);

            // Convert encrypted data to hex string for printing
            System.out.println("cipher: " + toHex(ciphertext));

            // Decrypt
            cipher.init(Cipher.DECRYPT_MODE, pubKey);
            byte[] decryptedHash = cipher.doFinal(ciphertext);

            // Convert decrypted hash to hex string for printing
            System.out.println("plaintext : " + toHex(decryptedHash));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}