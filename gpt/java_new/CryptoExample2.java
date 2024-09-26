import java.math.BigInteger;

public class CryptoExample2 {
    public static void main(String[] args) {
        // Assume y, a, b, c, and p are all BigIntegers initialized properly
        BigInteger y = new BigInteger("...");
        BigInteger a = new BigInteger("...");
        BigInteger b = new BigInteger("...");
        BigInteger c = new BigInteger("...");
        BigInteger p = new BigInteger("...");

        // Calculate y^(a*b) mod p
        BigInteger yab = y.modPow(a.multiply(b), p);
    }
}