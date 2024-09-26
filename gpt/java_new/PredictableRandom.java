import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class PredictableRandom {

    public static void main(String[] args) {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            System.out.println("Random number: " + secureRandom.nextInt());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}