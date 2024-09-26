import java.math.BigInteger;

public class Main34 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("2");
        BigInteger b = new BigInteger("3");
        BigInteger x = new BigInteger("4");
        BigInteger y = new BigInteger("5");
        BigInteger z = new BigInteger("7");

        BigInteger result = a.modPow(x, z).multiply(b.modPow(y, z)).mod(z);

        System.out.println(result);
    }
}