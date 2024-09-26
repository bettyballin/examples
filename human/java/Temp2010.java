import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp2010 {
    private static final String KEY_STRING = "MOGO_APP";

    public static void main(String[] args) {
        // Example usage
        String encryptedBase64 = "YourBase64EncryptedStringHere";
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedBase64);
        
        byte[] decryptedBytes = decrypt(encryptedBytes);
        if (decryptedBytes != null) {
            System.out.println(new String(decryptedBytes, StandardCharsets.UTF_8));
        }
    }

    public static byte[] decrypt(byte[] encrypt) {
        try {
            byte[] key = KEY_STRING.getBytes(StandardCharsets.US_ASCII);
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(encrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}