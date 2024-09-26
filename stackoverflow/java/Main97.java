import java.math.BigInteger;

public class Main97 {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("17"); // Example value for p
        BigInteger q = new BigInteger("19"); // Example value for q
        BigInteger e = new BigInteger("3");  // Example e value for RSA
        BigInteger d = e.modInverse(lcm(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE)));

        BigInteger lambda = lcm(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));
        boolean check2 = BigInteger.ONE.equals(d.multiply(e).mod(lambda));
        System.out.println(check2);
    }

    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }
}