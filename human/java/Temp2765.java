import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp2765 {
    public static void main(String[] args) {
        try {
            String data = "Hello, World!";
            String AES_key = "U2FsdGVkX19+5T6kB5fV3Q=="; // Example key, replace with your actual key
            String encryptedData = encryptAES(data, AES_key);
            System.out.println("Encrypted Data: " + encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptAES(String data, String AES_key) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(AES_key);
        SecretKeySpec secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}