import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Main {
    public static void main(String[] args) {
        try {
            // Generate a temporary AES key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            byte[] key = secretKey.getEncoded();

            // Sample data to encrypt
            String data = "Hello, World!";
            byte[] encryptedData = encryptAES(key, data);

            // Convert the bytes into base 64 string.
            String encodedString = Base64.encodeBase64String(encryptedData);

            System.out.println("Encoded Data: " + encodedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] encryptAES(byte[] key, String data) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data.getBytes("UTF-8"));
    }
}