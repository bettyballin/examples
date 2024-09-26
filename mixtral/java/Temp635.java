import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Temp635 {
    public static void main(String[] args) {
        try {
            String algorithm = "AES/ECB/PKCS5Padding";
            String key = "1234567890123456"; // 16-byte key for AES-128
            String dataToDecrypt = "encryptedData"; // replace with actual encrypted data

            Cipher cipher = Cipher.getInstance(algorithm);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] decodedData = Base64.getDecoder().decode(dataToDecrypt);
            byte[] decryptedData = cipher.doFinal(decodedData);

            System.out.println(new String(decryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}