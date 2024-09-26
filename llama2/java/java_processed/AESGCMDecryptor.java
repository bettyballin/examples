import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Base64;

public class AESGCMDecryptor {
    public static void main(String[] args) {
        String key = "0123456789abcdef"; // 16-byte secret key
        String iv = "0123456789abcdef"; // 16-byte initialization vector
        String tag = "0123456789abcdef"; // 16-byte authentication tag
        String encryptedText = "Base64EncodedEncryptedText"; // Placeholder for the encrypted text

        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            
            byte[] ivBytes = iv.getBytes();
            byte[] tagBytes = tag.getBytes();
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

            GCMParameterSpec gcmParam = new GCMParameterSpec(tagBytes.length * 8, ivBytes);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParam);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            String decryptedText = new String(decryptedBytes);

            System.out.println("Decrypted text: " + decryptedText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}