import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class PMAdminKeyTest {

    public static void main(String[] args) throws Exception {
        // Requirement is to generate Key based on password and salt
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec keySpec = new PBEKeySpec("password".toCharArray(), "salt".getBytes(), 65536, 192);
        SecretKey key = new SecretKeySpec(secretKeyFactory.generateSecret(keySpec).getEncoded(), "DESede");

        System.out.println("key.getAlgorithm(): " + key.getAlgorithm());

        byte[] data = "12345678".getBytes("UTF8");

        // Existing encrypt and decrypt code. There is already lot of data in DB
        // encrypted in this manner. I dont think I can change this code.
        Cipher cipher = Cipher.getInstance(key.getAlgorithm() + "/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data);

        System.out.println("encryptedData: " + new String(encryptedData));

        cipher.init(Cipher.DECRYPT_MODE, key);

        // Notice this
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // while printing the data use UTF-8 
        System.out.println("decryptedData: " + new String(decryptedData, "UTF-8"));
    }
}