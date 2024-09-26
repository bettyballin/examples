import java.math.BigInteger;

public class Temp418 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("56");
        BigInteger b = new BigInteger("98");

        BigInteger c = gcd(a, b);
        System.out.println("GCD: " + c);
    }

    public static BigInteger gcd(BigInteger num1, BigInteger num2) {
        if (num2.equals(BigInteger.ZERO)) return num1;
        else return gcd(num2, num1.mod(num2));
    }
}