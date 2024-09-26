import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main {
    public static void main(String[] args) {
        try {
            // Set up key and IV
            byte[] keyBytes = "0123456789abcdef".getBytes(StandardCharsets.UTF_8);
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            byte[] iv = new byte[16];
            Arrays.fill(iv, (byte) 'A');
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            // Set up plaintext
            String plaintext = "test text 123";
            byte[] plaintextBytes = new byte[16];
            System.arraycopy(plaintext.getBytes(StandardCharsets.UTF_8), 0, plaintextBytes, 0, plaintext.length());

            System.out.println("==Java==");
            System.out.println("plain:   " + plaintext);

            // Encrypt
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            byte[] cipherText = cipher.doFinal(plaintextBytes);
            System.out.print("cipher:  ");
            display(cipherText);

            // Decrypt
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
            byte[] decryptedText = cipher.doFinal(cipherText);
            System.out.println("decrypt: " + new String(decryptedText, StandardCharsets.UTF_8).trim());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void display(byte[] buffer) {
        for (byte b : buffer) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}