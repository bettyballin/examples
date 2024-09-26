import java.math.BigInteger;
import java.security.SecureRandom;

public class Temp2011 {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(2048, random);
        BigInteger q = BigInteger.probablePrime(2048, random);

        System.out.println("p: " + p);
        System.out.println("q: " + q);
    }
}