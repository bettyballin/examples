import java.security.SecureRandom;
import java.math.BigInteger;

public class RandomStringGenerator {
    public static void main(String[] args) {
        SecureRandom rnd = new SecureRandom();
        /* Bit length is multiple of log2(32) = 5. */
        String encoded = new BigInteger(130, rnd).toString(32);
        System.out.println(encoded);
    }
}