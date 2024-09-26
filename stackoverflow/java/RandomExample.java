import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class RandomExample {
    public static void main(String[] args) {
        SecureRandom rand = null;
        try {
            rand = SecureRandom.getInstance("NativePRNGBlocking");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}