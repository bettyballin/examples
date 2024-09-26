import java.math.BigInteger;

public class Temp1276 {
    public static void main(String[] args) {
        BigInteger y = new BigInteger("123456789"); // Example value for y
        BigInteger ab = new BigInteger("987654321"); // Example value for ab
        BigInteger cb = new BigInteger("123456789"); // Example value for cb
        BigInteger p = new BigInteger("1000000007"); // Example value for p

        BigInteger yabc = y.pow((int) (ab.longValue() - cb.longValue()));
        BigInteger ans = yabc.mod(p);

        System.out.println("Result: " + ans);
    }
}