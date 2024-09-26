import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp2614 {
    public static void main(String[] args) {
        try {
            example();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void example() throws NoSuchAlgorithmException {
        {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(12345678L);
            System.out.println(secureRandom.nextLong());
        }
        {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(12345678L);
            System.out.println(secureRandom.nextLong());
        }
    }
}