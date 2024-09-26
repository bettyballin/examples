import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.util.Base64;

public class Temp1032 {

    public static void main(String[] args) {
        try {
            String encryptedData = "YourEncryptedDataHere"; // Replace with your actual encrypted data
            String decryptedData = decrypt(encryptedData);
            System.out.println("Decrypted Data: " + decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();

        // Create a new Initialization Vector
        byte[] ivBytes = "gqLOHUioQ0QjhuvI".getBytes("UTF-8");

        IvParameterSpec IV = new IvParameterSpec(ivBytes);

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Initialize the cipher with both key and initialization vector
        c.init(Cipher.DECRYPT_MODE, key, IV);

        byte[] decodedValue = Base64.getDecoder().decode(encryptedData);

        byte[] decValue = c.doFinal(decodedValue);

        String decryptedValue = new String(decValue);

        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example, 128-bit key
        SecretKey secretKey = keyGen.generateKey();
        return secretKey;
    }
}