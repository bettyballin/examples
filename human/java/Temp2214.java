import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class Temp2214 {
    public static void main(String[] args) {
        String encryptedText = "your_base64_encoded_encrypted_text_here";
        System.out.println(decrypt(encryptedText));
    }

    public static String decrypt(String src) {
        String decrypted = "";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            // Decode input
            byte[] array = Base64.getDecoder().decode(src);
            // Read first 16 bytes (IV data)
            byte[] ivData = Arrays.copyOfRange(array, 0, 16);
            // Read last 16 bytes (encrypted text)
            byte[] encrypted = Arrays.copyOfRange(array, 16, array.length);
            // Init the cipher with decrypt mode, key, and IV bytes array (no more hardcoded)
            cipher.init(Cipher.DECRYPT_MODE, makeKey(), new IvParameterSpec(ivData));
            // Decrypt same old way
            decrypted = new String(cipher.doFinal(encrypted)).trim();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return decrypted;
    }

    private static SecretKeySpec makeKey() {
        // The key used for decryption, must be 16 bytes for AES-128
        byte[] keyBytes = "your_16_byte_key".getBytes();
        return new SecretKeySpec(keyBytes, "AES");
    }
}