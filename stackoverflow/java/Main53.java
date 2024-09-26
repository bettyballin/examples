import java.math.BigInteger;

public class Main53 {
    public static void main(String[] args) {
        BigInteger y = new BigInteger("2"); // Placeholder for the actual value
        BigInteger ab = new BigInteger("3"); // Placeholder for the actual value
        BigInteger cb = new BigInteger("1"); // Placeholder for the actual value
        BigInteger p = new BigInteger("5"); // Placeholder for the actual value

        BigInteger yabc = y.pow(ab.subtract(cb).intValue());
        BigInteger ans = yabc.mod(p);

        System.out.println(ans); // Output the result
    }
}