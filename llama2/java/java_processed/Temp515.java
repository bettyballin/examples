import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp515 {
    public static void main(String[] args) {
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            System.out.println("SecureRandom instance created successfully.");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No such algorithm exception: " + e.getMessage());
        }
    }
}