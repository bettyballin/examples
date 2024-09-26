import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Temp361 {
    public static void main(String[] args) {
        Random r = new SecureRandom();    
        BigInteger q = new BigInteger("1234567891011121314151617181920"); // Example big integer
        BigInteger ans;
        int bits_in_q = q.bitLength();

        do {
            ans = new BigInteger(bits_in_q, r);
        } while (ans.compareTo(q) >= 0); // bn_rand_range generates numbers < q

        System.out.println("Generated number: " + ans);
    }
}