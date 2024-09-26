import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;

public class Temp3169 {
    public static void main(String[] args) {
        String encryptedText = "YourEncryptedTextHere"; // Replace with your encrypted text
        String secretKey = "YourSecretKeyHere"; // Replace with your secret key
        String decryptedText = decrypt(encryptedText, secretKey);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    public static String decrypt(String strToDecrypt, String secretKey) {
        try {
            byte[] decodedCiphertext = new Base64().decode(strToDecrypt);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] salt = Arrays.copyOfRange(decodedCiphertext, 0, 16);
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt, 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] iv = Arrays.copyOfRange(decodedCiphertext, 16, 32);
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, secret, ivspec);

            byte[] plaintext = cipher.doFinal(Arrays.copyOfRange(decodedCiphertext, 32, decodedCiphertext.length));
            System.out.println("Finished decryption");
            return new String(plaintext, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}