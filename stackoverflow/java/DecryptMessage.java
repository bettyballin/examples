import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class DecryptMessage {
    public static void main(String[] args) {
        try {
            byte[] iv = /* Initialization Vector */;
            byte[] ciphertext = /* Encrypted Data */;
            byte[] keyBytes = /* Key Data */;

            SecretKeySpec secret = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
            String plaintext = new String(cipher.doFinal(ciphertext), StandardCharsets.UTF_8);
            System.out.println(plaintext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}