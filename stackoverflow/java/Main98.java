import java.math.BigInteger;

public class Main98 {
    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }

    public static void main(String[] args) {
        BigInteger a = new BigInteger("15");
        BigInteger b = new BigInteger("20");
        System.out.println("LCM of " + a + " and " + b + " is " + lcm(a, b));
    }
}