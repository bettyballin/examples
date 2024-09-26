import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Temp2696 {
    private static final String SECRET_KEY = "B5V6SjkjJpeOxvMAkPf7EA==";

    public static void main(String[] args) {
        String encryptedText1 = "NNDA7o+Dpd+M+H99WVxY0B8adqVWJHZ+HIjgPxMljwo=";
        String encryptedText2 = "4H1SpH8N+/jqU40G6RWb+ReHUB3C58iAaU4l39j+TV8=";

        System.out.println("test 1: " + validate(encryptedText1, true));
        System.out.println("test 2: " + validate(encryptedText2, false));
    }

    private static boolean validate(String encryptedText, boolean expectedValidity) {
        try {
            String decryptedText = decrypt(encryptedText, SECRET_KEY);
            return expectedValidity == decryptedText.equals("test");
        } catch (Exception e) {
            return !expectedValidity;
        }
    }

    private static String decrypt(String strToDecrypt, String secret) {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(secret);
            SecretKeySpec secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}