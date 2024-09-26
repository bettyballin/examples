import java.math.BigInteger;
import java.util.Random;

public class CoprimeFinder {
    public static void main(String[] args) {
        Random random = new Random();
        BigInteger a = BigInteger.probablePrime(16, random);
        BigInteger b = BigInteger.probablePrime(16, random);
        BigInteger c = BigInteger.ONE;

        while (c.equals(BigInteger.ONE) || a.gcd(c).compareTo(BigInteger.ONE) > 0 || b.gcd(c).compareTo(BigInteger.ONE) > 0) {
            c = new BigInteger(16, random);
        }
        System.out.println("A non-trivial coprime number for both " + a + " and " + b + " is: " + c);
    }
}