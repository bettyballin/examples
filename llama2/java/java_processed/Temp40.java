import java.math.BigInteger;
import java.util.List;

public class Temp40 {
    public static void main(String[] args) {
        // Example usage
        BigInteger p = new BigInteger("23");
        BigInteger a = new BigInteger("5");
        List<BigInteger> f = List.of(new BigInteger("2"), new BigInteger("11"));
        System.out.println(order(p, a, f));
    }

    public static BigInteger order(BigInteger p, BigInteger a, List<BigInteger> f) {
        BigInteger t = p.subtract(BigInteger.ONE);
        for (BigInteger factor : f) {
            BigInteger t1 = t.divide(factor);
            if (a.modPow(t1, p).equals(BigInteger.ONE)) {
                return t1;
            }
        }
        return t; // If no factor works, return t
    }
}