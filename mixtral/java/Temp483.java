import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.util.Arrays;

public class Temp483 {
    public static void main(String[] args) {

        try {
            // Initialize your AES-CTR or AES-CBC decryption cipher
            String key = "0123456789abcdef"; // Example key, should be 16 bytes for AES-128
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher ci = Cipher.getInstance("AES/CTR/NoPadding"); // Use AES/CTR or AES/CBC depending on your requirement
            ci.init(Cipher.DECRYPT_MODE, secretKey);

            try (FileInputStream fis = new FileInputStream("encrypted_video.mp4");
                 InputStream is = new CipherInputStream(fis, ci)) {

                byte[] buffer = new byte[16]; // 128 bits

                int bytesRead;

                while ((bytesRead = is.read(buffer)) != -1) {
                    System.out.println("Decrypted block: " + Arrays.toString(buffer));

                    // Process the decrypted data here

                    if (shouldStop()) break;

                    buffer = new byte[16];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean shouldStop() {
        // Implement your stopping condition here
        return false;
    }
}