import java.math.BigInteger;

public class Temp1258 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("12345678901234567890");
        BigInteger b = new BigInteger("98765432109876543210");
        
        BigInteger c = a.gcd(b); // or equivalently b.gcd(a)
        System.out.println("GCD: " + c);
    }
}