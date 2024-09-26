import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class PMAdminKeyTest {

    public static void main(String[] args) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec keySpec = new PBEKeySpec("password".toCharArray(), "salt".getBytes(StandardCharsets.UTF_8), 65536, 192);
        SecretKeySpec key = new SecretKeySpec(secretKeyFactory.generateSecret(keySpec).getEncoded(), "DESede");

        System.out.println("key.getAlgorithm(): " + key.getAlgorithm());

        byte[] data = "12345678".getBytes(StandardCharsets.UTF_8);

        Cipher cipher = Cipher.getInstance(key.getAlgorithm() + "/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data);

        System.out.println("encryptedData: " + new String(encryptedData, StandardCharsets.UTF_8));

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(encryptedData);

        System.out.println("decryptedData: " + new String(decryptedData, StandardCharsets.UTF_8));
    }
}