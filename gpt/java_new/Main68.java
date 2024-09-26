import java.math.BigInteger;

public class Main68 {
    public static void main(String[] args) {
        BigInteger s1 = new BigInteger("your value of s1"); // Replace with actual value
        BigInteger s2 = new BigInteger("your value of s2"); // Replace with actual value
        BigInteger N = new BigInteger("your modulus N"); // Replace with actual value

        // Calculate the modular inverse of s1
        BigInteger s1_inv = s1.modInverse(N);

        // Multiply s2 by the modular inverse of s1
        BigInteger result = s2.multiply(s1_inv).mod(N);

        System.out.println(result);
    }
}