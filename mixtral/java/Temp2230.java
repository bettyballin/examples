import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp2230 {
    public static void main(String[] args) {
        try {
            SecureRandom r = new SecureRandom();
            byte[] ivBytes = new byte[16];
            r.nextBytes(ivBytes);
            IvParameterSpec iv = new IvParameterSpec(ivBytes);
            
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            SecretKeySpec aesKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, aesKeySpec, iv);
            
            System.out.println("Cipher initialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}