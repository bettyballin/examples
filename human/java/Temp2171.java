import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp2171 {
    public static void main(String[] args) {
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            System.out.println("Random number: " + random.nextInt());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No strong secure random number generator available: " + e.getMessage());
        }
    }
}