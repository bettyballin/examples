import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Temp811 {
    public static void main(String[] args) {
        char[] passChars = "password".toCharArray();
        byte[] saltBytes = "saltsalt".getBytes();
        int iterations = 2048 + (int) System.currentTimeMillis();
        int keyLength = 128;

        try {
            PBEKeySpec keySpec = new PBEKeySpec(passChars, saltBytes, iterations, keyLength);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] keyBytes = keyFactory.generateSecret(keySpec).getEncoded();
            
            System.out.println("Secret key: " + new String(keyBytes));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}