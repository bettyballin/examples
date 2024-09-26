import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp2587 {
    public static void main(String[] args) {
        try {
            SecureRandom rand = SecureRandom.getInstanceStrong();
            System.out.println("SecureRandom instance created successfully.");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm exception: " + e.getMessage());
        }
    }
}