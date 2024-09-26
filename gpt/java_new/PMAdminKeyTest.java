import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class PMAdminKeyTest {

    public static void main(String[] args) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        
        char[] password = "somepassword".toCharArray();
        int iterationCount = 65536;
        int keyLength = 256;
        
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = skf.generateSecret(spec).getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        
        byte[] plaintext = "someplaintext".getBytes("UTF-8");
        byte[] ciphertext = cipher.doFinal(plaintext);
        
        System.out.println("Ciphertext: " + new String(ciphertext, "UTF-8"));
    }
}