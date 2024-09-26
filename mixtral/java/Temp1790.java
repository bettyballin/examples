import java.math.BigInteger;

public class Temp1790 {
    public static void main(String[] args) {
        BigInteger s1 = new BigInteger("12345"); // Example value
        BigInteger s2 = new BigInteger("67890"); // Example value
        BigInteger N = new BigInteger("98765");  // Example value

        BigInteger rInv = s1.modInverse(N);
        BigInteger x = s2.multiply(rInv).mod(N);
        
        System.out.println("Result: " + x);
    }
}