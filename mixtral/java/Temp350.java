import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp350 {
    public static void main(String[] args) {
        try {
            String strToDecrypt = "your_base64_encoded_string_here";
            String secretKey = "your_secret_key_here"; // Ensure this is a valid key for the algorithm

            byte[] decodedData = Base64.getDecoder().decode(strToDecrypt);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decBytes = cipher.doFinal(decodedData);
            String decStr = new String(decBytes);
            System.out.println(decStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}