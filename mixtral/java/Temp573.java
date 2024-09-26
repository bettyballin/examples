import java.math.BigInteger;

public class Temp573 {
    public static void main(String[] args) {
        BigInteger y = new BigInteger("2"); // Example value for y
        BigInteger ap = new BigInteger("3"); // Example value for a
        BigInteger b = new BigInteger("4"); // Example value for b
        BigInteger c = new BigInteger("5"); // Example value for c
        BigInteger p = new BigInteger("7"); // Example value for p

        BigInteger ya = y.modPow(ap, p);
        ya = ya.pow(b.intValue()).mod(p);

        // Calculate the modular multiplicative inverse of (y^c)^b
        BigInteger ycb = y.modPow(c, p).pow(b.intValue()).mod(p);
        BigInteger invYcb = ycb.modInverse(p);

        // Calculate the modular multiplicative inverse of (y^a)^b
        BigInteger ans = ya.multiply(invYcb).mod(p);

        System.out.println("Answer: " + ans);
    }
}