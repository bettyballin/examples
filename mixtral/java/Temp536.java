import java.math.BigInteger;

public class Temp536 {
    public static void main(String[] args) {
        // Example values (you should replace these with actual values)
        BigInteger g = new BigInteger("2");
        BigInteger u1 = new BigInteger("3");
        BigInteger u2 = new BigInteger("4");
        BigInteger p = new BigInteger("17");
        BigInteger q = new BigInteger("5");
        BigInteger y = new BigInteger("6");
        
        BigInteger v = g.modPow(u1, p);
        v = v.multiply(y.modPow(u2, p)).mod(p);
        v = v.mod(q);
        
        System.out.println(v);
    }
}