import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SomeClass11 {

    public void example() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(12345678L);
        System.out.println(secureRandom.nextLong());

        secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(12345678L);
        System.out.println(secureRandom.nextLong());
    }
}