import java.math.BigInteger;

public class Temp424 {
    public static void main(String[] args) {
        // Example values for y, ab, cb, p
        BigInteger y = new BigInteger("123456789");
        BigInteger ab = new BigInteger("987654321");
        BigInteger cb = new BigInteger("123456789");
        BigInteger p = new BigInteger("1000000007");

        BigInteger yab = y.modPow(ab, p);
        BigInteger ycb = y.modPow(cb, p);

        BigInteger ans = yab.multiply(ycb.modInverse(p)).mod(p);
        
        System.out.println("The result is: " + ans);
    }
}