import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class Temp1193 {
    public static void main(String[] args) {
        try {
            // Initialize message digest
            MessageDigest hash = MessageDigest.getInstance("SHA-256");
            hash.update("Test message".getBytes());
            
            // Generate secret key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256, new SecureRandom());
            SecretKey secretKey = keyGen.generateKey();
            
            // Initialize cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            // Print digest
            System.out.println("digest : " + bytesToHex(hash.digest()));   //1
            
            // Perform encryption
            byte[] ciphertext = cipher.doFinal(hash.digest()); //2
            System.out.println("ciphertext : " + bytesToHex(ciphertext));
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}