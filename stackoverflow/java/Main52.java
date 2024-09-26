import java.math.BigInteger;

public class Main52 {
    public static void main(String[] args) {
        BigInteger y = new BigInteger("2"); // Example values
        BigInteger ab = new BigInteger("10");
        BigInteger cb = new BigInteger("5");
        BigInteger p = new BigInteger("7");

        BigInteger yab = y.pow(ab.intValue());
        BigInteger ycb = y.pow(cb.intValue());

        BigInteger ans = yab.divide(ycb).mod(p);
        System.out.println(ans);
    }
}