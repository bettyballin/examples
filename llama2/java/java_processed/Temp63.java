import java.security.*;
import javax.crypto.*;

public class Temp63 {
    public static void main(String[] args) {
        try {
            // Generate a key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();

            // Create a Cipher object
            Cipher cipher = Cipher.getInstance("RSA");

            // Initialize the cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            // Add data to the cipher
            byte[] input = "Hello, World!".getBytes();
            cipher.update(input);

            // Encrypt the data
            byte[] cipherText = cipher.doFinal();
            System.out.println("Encrypted Text: " + bytesToHex(cipherText));

            // Initialize the cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            // Decrypt the data
            byte[] decipheredText = cipher.doFinal(cipherText);
            System.out.println("Decrypted Text: " + new String(decipheredText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}