import java.math.BigInteger;

public class Temp187 {
    public static void main(String[] args) {

        BigInteger a = new BigInteger("123456789");
        BigInteger x = new BigInteger("3");
        BigInteger b = new BigInteger("987654321");
        BigInteger y = new BigInteger("2");
        BigInteger z = new BigInteger("1000000007");

        // Compute (a^x * b^y) % z

        // First compute (b^y) % z using modPow method
        BigInteger byModZ = b.modPow(y, z);

        // Then multiply it with a^x and take modulo again
        BigInteger ax = a.modPow(x, z);
        BigInteger result = ax.multiply(byModZ).mod(z);

        System.out.println("Result: " + result);
    }
}