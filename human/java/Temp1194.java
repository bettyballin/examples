import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Temp1194 {
    public static void main(String[] args) {
        try {
            // Initialize MessageDigest with SHA-256
            MessageDigest hash = MessageDigest.getInstance("SHA-256");
            
            // Sample input for hashing
            String input = "example input";
            hash.update(input.getBytes());
            byte[] inputHash = hash.digest();

            System.out.println("digest : " + bytesToHex(inputHash));

            // Initialize Cipher with AES algorithm
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256, new SecureRandom());
            SecretKey secretKey = keyGen.generateKey();

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] ciphertext = cipher.doFinal(inputHash);

            System.out.println("ciphertext : " + bytesToHex(ciphertext));

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | javax.crypto.IllegalBlockSizeException | javax.crypto.BadPaddingException e) {
            e.printStackTrace();
        }
    }

    // Utility method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}