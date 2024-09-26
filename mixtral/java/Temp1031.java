import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Temp1031 {
    public static void main(String[] args) {
        try {
            String data = "Hello, World!";
            String encryptedData = encrypt(data);
            System.out.println("Encrypted Data: " + encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String data) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();

        // Create a new Initialization Vector
        byte[] ivBytes = "gqLOHUioQ0QjhuvI".getBytes(StandardCharsets.UTF_8);

        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Initialize the cipher with both key and initialization vector
        c.init(Cipher.ENCRYPT_MODE, key, iv);

        byte[] encVal = c.doFinal(data.getBytes());

        String encryptedValue = Base64.getEncoder().encodeToString(encVal);

        return encryptedValue;
    }
}