import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class Temp2200 {
    public static void main(String[] args) {
        try {
            // Generate a temporary AES key. In practice, you would retrieve this from a secure location.
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example 256-bit AES
            SecretKey secretKey = keyGen.generateKey();

            // Convert the secret key to a SecretKeySpec
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

            System.out.println("SecretKeySpec: " + secretKeySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}