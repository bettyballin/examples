import java.math.BigInteger;

public class Main14 {
    public static void main(String[] args) {
        BigInteger x = new BigInteger("Your x value here");
        BigInteger q = new BigInteger("Your q value here");
        BigInteger r = new BigInteger("Your r value here");
        BigInteger g = new BigInteger("Your g value here");

        // Assuming q is a prime number and we want to find the modular inverse with respect to q-1
        // Refactored code
        BigInteger x_inverse = x.modInverse(q.subtract(BigInteger.ONE));
        BigInteger r_x_inverse = r.multiply(x_inverse).mod(q.subtract(BigInteger.ONE));
        BigInteger g_r_corrected = g.modPow(r_x_inverse, q);

        System.out.println(g_r_corrected); // This should give you the correct result
    }
}