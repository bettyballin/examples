import java.math.BigInteger;

public class Temp3372 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("12");
        BigInteger b = new BigInteger("18");
        
        BigInteger result = lcm(a, b);
        System.out.println("LCM of " + a + " and " + b + " is " + result);
    }

    private static BigInteger lcm(BigInteger a, BigInteger b) {
        BigInteger mul = a.multiply(b);
        BigInteger gcd = a.gcd(b);
        BigInteger lcm = mul.divide(gcd);
        return lcm;
    }
}