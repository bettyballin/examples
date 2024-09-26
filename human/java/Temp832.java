import java.math.BigInteger;

public class Temp832 {
    public static void main(String[] args) {
        // Sample values for a, b, x, y, z
        BigInteger a = new BigInteger("123456789");
        BigInteger b = new BigInteger("987654321");
        BigInteger x = new BigInteger("12345");
        BigInteger y = new BigInteger("67890");
        BigInteger z = new BigInteger("100000");

        BigInteger result = a.modPow(x, z).multiply(b.modPow(y, z)).mod(z);
        System.out.println("Result: " + result);
    }
}