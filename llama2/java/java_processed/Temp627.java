import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp627 {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "1234567890123456"; // Example key, must be 16 bytes for AES-128

    public static void main(String[] args) {
        String str = "YourEncryptedStringHere"; // Replace with your actual encrypted string
        String decrypted = decrypt(str);
        System.out.println(decrypted);
    }

    public static String decrypt(String strToDecrypt) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodedBytes = Base64.getDecoder().decode(strToDecrypt);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}