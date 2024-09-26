import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp869 {
    public static void main(String[] args) {
        try {
            String sKey = "your-secret-key"; // Replace with your actual secret key
            SecretKey secretKey = null;
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(sKey.getBytes());
            kgen.init(128, secureRandom);
            secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();

            // For demonstration purposes, print the encoded format of the key
            System.out.println(java.util.Base64.getEncoder().encodeToString(enCodeFormat));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}