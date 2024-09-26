import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp587 {
    public static void main(String[] args) {
        try {
            byte[] ivBytes = new byte[16]; // Example IV, should be replaced with actual IV
            byte[] keyBytes = new byte[16]; // Example key, should be replaced with actual key
            byte[] encryptedText = new byte[16]; // Example encrypted text, should be replaced with actual encrypted data

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParams = new IvParameterSpec(ivBytes);
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParams);

            // Decrypt the data
            byte[] decryptedData = cipher.doFinal(encryptedText);

            // Print decrypted data
            System.out.println(new String(decryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}