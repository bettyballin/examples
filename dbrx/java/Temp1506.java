import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp1506 {
    public static void main(String[] args) {
        SecretKeySpec key = genKey();
        if (key != null) {
            System.out.println("Key generated successfully: " + key);
        } else {
            System.out.println("Key generation failed.");
        }
    }

    public static SecretKeySpec genKey() {
        try {
            // Generate a 128-bit key
            byte[] key = new byte[16];
            SecureRandom secureRandom = SecureRandom.getInstance("NativePRNG");
            secureRandom.nextBytes(key);
            return new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}