import java.math.BigInteger;

public class Temp3371 {
    // Helper method to compute the greatest common divisor
    private static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return a;
    }

    // Helper method to compute the least common multiple
    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(gcd(a, b));
    }

    public static void main(String[] args) {
        BigInteger p = new BigInteger("17");
        BigInteger q = new BigInteger("23");
        BigInteger e = new BigInteger("65537");
        BigInteger d = new BigInteger("413");

        BigInteger lambda = lcm(p.subtract(BigInteger.ONE), q.subtract(BigInteger.ONE));
        boolean check2 = BigInteger.ONE.equals(d.multiply(e).mod(lambda)); // d * e mod lambda == 1 ?  <-- true for ALL cases
        System.out.println(check2);
    }
}