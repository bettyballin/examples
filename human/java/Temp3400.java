import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Temp3400 {
    public static void main(String[] args) {
        try {
            String encodedString = "0O15lUg8sE1G0+BjO5N2j8AjVKXV4J+18z5DinbM6tYjoILhL0WDTFWbcTiN+pG/";
            String passphrase = "my passphrase";
            String salt = "my salt";

            // Generate key
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

            // Decrypt
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(new byte[16]);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            String decryptedString = new String(decryptedBytes, StandardCharsets.UTF_8);

            System.out.println("Result: " + decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}