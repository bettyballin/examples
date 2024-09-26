import java.math.BigInteger;

public class Temp1482 {
    public static void main(String[] args) {
        BigInteger e = new BigInteger("3");
        BigInteger prime = new BigInteger("11");
        BigInteger q = new BigInteger("7");
        
        while (true) {
            // ...

            BigInteger gcd = e.gcd(prime.subtract(BigInteger.ONE));

            if ((e.compareTo(BigInteger.ZERO) > 0 &&
                 e.compareTo(q) < 0) ||
                (gcd.equals(BigInteger.ONE))) {
                break;
            }
        }
    }
}