import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;

public class Main26 {
    public static void main(String[] args) throws Exception {
        char[] password = "somePassword".toCharArray();
        byte[] salt = new byte[16]; // Example salt. Replace with random bytes.
        int iterations = 10000;

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey aesKey = factory.generateSecret(new PBEKeySpec(password, salt, iterations, 256));
    }
}