import java.util.Base64;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp2208 {
    public static void main(String[] args) {
        try {
            // Example base64 encoded data (includes IV + encrypted data)
            String src = "your_base64_encoded_string_here";

            // Decode base64
            byte[] array = Base64.getDecoder().decode(src);

            // Get only encrypted data (removing first 16 bytes, namely the IV)
            byte[] iv = Arrays.copyOfRange(array, 0, 16);
            byte[] encrypted = Arrays.copyOfRange(array, 16, array.length);

            // Example key (must be 16 bytes for AES-128)
            byte[] keyBytes = "your_secret_key_16".getBytes("UTF-8");

            // Initialize cipher for decryption (AES/CBC/PKCS5Padding)
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            // Decrypt data
            byte[] decryptedBytes = cipher.doFinal(encrypted);
            String decrypted = new String(decryptedBytes, "UTF-8");

            // Print decrypted data
            System.out.println(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}