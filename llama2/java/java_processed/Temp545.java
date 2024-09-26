import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class Temp545 {
    public static void main(String[] args) {
        try {
            // Generate a secret key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for AES-256
            SecretKey secret = keyGen.generateKey();

            // Generate a secure random IV
            SecureRandom sr = new SecureRandom();
            byte[] iv = new byte[16]; // AES block size is 16 bytes
            sr.nextBytes(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            // Create a Cipher instance
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            // Use the generated IV for encryption
            cipher.init(Cipher.ENCRYPT_MODE, secret, ivSpec);
            String plaintext = "Hello, World!";
            byte[] encrypted = cipher.doFinal(plaintext.getBytes());
            System.out.println("Encrypted: " + bytesToHex(encrypted));

            // Use the same IV for decryption
            cipher.init(Cipher.DECRYPT_MODE, secret, ivSpec);
            byte[] decrypted = cipher.doFinal(encrypted);
            System.out.println("Decrypted: " + new String(decrypted));
        } catch (Exception e) {
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