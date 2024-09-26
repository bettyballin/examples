import java.math.BigInteger;
import java.security.SecureRandom;

public class Main19 {
    public static void main(String[] args) {
        SecureRandom r = new SecureRandom();
        int bits_in_q = 512; // Assuming some bit length for q here
        BigInteger q = new BigInteger(bits_in_q, r); // something_big should be initialized
        BigInteger ans;

        do {
            ans = new BigInteger(bits_in_q, r);
        } while (ans.compareTo(q) >= 0);
    }
}