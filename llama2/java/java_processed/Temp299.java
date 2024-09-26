import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp299 {
    public static void main(String[] args) {
        byte[] salt = new byte[8];
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.nextBytes(salt);
            // Print the generated salt for verification
            System.out.println(java.util.Arrays.toString(salt));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}