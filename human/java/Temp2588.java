import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp2588 {
    public static void main(String[] args) {
        try {
            SecureRandom rand = SecureRandom.getInstance("NativePRNGBlocking");
            System.out.println("SecureRandom instance created successfully.");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algorithm not found: " + e.getMessage());
        }
    }
}