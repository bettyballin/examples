import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp720 {

    public static void main(String[] args) throws Exception {
        String encryptedText = "your_encrypted_text_here";
        String key = "your_16_byte_key"; // 16 bytes key for AES-128

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");

        Cipher cipherDecryption = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipherDecryption.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] decryptedData = cipherDecryption.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedData);

        System.out.println("Decrypted text: " + decryptedText);
    }
}