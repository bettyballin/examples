import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptionUtil5 {

    private static final String CIPHER_TRANSFORM = "AES/GCM/NoPadding";

    private static String encryptText(String plainText, String plainTextKey, String token, String alg) {
        try {
            // Create SecretKey & Cipher
            SecretKeySpec sks = new SecretKeySpec(Base64.getDecoder().decode(plainTextKey), alg);
            Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORM);

            // Setup byte arrays
            byte[] input = plainText.getBytes(StandardCharsets.UTF_8);
            byte[] tkb = token.getBytes(StandardCharsets.UTF_8);
            byte[] iv = new byte[12];
            System.arraycopy(tkb, 4, iv, 0, 12);
            cipher.init(Cipher.ENCRYPT_MODE, sks, new GCMParameterSpec(128, iv));
            cipher.updateAAD(tkb);

            // Encrypt the plaintext
            byte[] cipherText = cipher.doFinal(input);

            // Return Base64 encoded string
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Example usage
    public static void main(String[] args) {
        String encryptedText = encryptText("MyPlainText", "MyPlainTextKey", "MyToken", "AES");
        System.out.println(encryptedText);
    }
}