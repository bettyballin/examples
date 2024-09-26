import java.math.BigInteger;

public class RSALambdaCalculation {

    public static void main(String[] args) {
        // This is just an example, replace with actual prime numbers
        BigInteger p = new BigInteger("17");
        BigInteger q = new BigInteger("19");
        
        BigInteger lambda = calculateLambda(p, q);
        // ... rest of your code
    }

    private static BigInteger calculateLambda(BigInteger p, BigInteger q) {
        BigInteger pMinusOne = p.subtract(BigInteger.ONE);
        BigInteger qMinusOne = q.subtract(BigInteger.ONE);
        BigInteger lcm = lcm(pMinusOne, qMinusOne);
        return lcm;
    }

    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }
}