import java.math.BigInteger;

public class Temp2304 {
    public static void main(String[] args) {
        BigInteger one = new BigInteger("1");
        BigInteger n = new BigInteger("some value"); // Replace with actual value
        BigInteger p = new BigInteger("some value"); // Replace with actual value
        BigInteger q = new BigInteger("some value"); // Replace with actual value
        BigInteger d = new BigInteger("some value"); // Replace with actual value
        BigInteger phi = new BigInteger("some value"); // Replace with actual value
        
        boolean check0 = n.equals(p.multiply(q));

        // Verify that e * d mod (phi) == 1
        boolean check1 = one.compareTo(d.modPow(d, phi)) == 0;

        // Alternatively:
        BigInteger gcdResult = p.subtract(one).gcd(q.subtract(one));

        // Verify that (p-1) and (q-1) are relatively prime
        boolean check2 = one.compareTo(gcdResult) == 0;

        // Print results
        System.out.println("Check0: " + check0);
        System.out.println("Check1: " + check1);
        System.out.println("Check2: " + check2);
    }
}