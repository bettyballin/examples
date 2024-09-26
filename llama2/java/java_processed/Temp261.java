import java.math.BigInteger;

public class Temp261 {
    public static void main(String[] args) {
        BigInteger g = new BigInteger("REPLACE_WITH_1024_BIT_PRIME"); // your 1024-bit prime
        BigInteger u1 = new BigInteger("666075361584433975742185154706661067887879287196");
        BigInteger p = new BigInteger("REPLACE_WITH_1024_BIT_MODULUS"); // your 1024-bit modulus

        // Initialize the result and the intermediate values
        BigInteger result = BigInteger.ONE;
        BigInteger g_pow = g;

        // Perform the modular exponentiation in a series of smaller steps
        for (int i = 0; i < u1.bitLength(); i += 32) {
            // Compute g^i mod p
            BigInteger temp = g_pow.modPow(BigInteger.valueOf(32), p); // changed to 32
            // Update the intermediate value
            g_pow = temp.multiply(g).mod(p);
            // Update the result
            result = result.multiply(temp).mod(p); // corrected update
        }

        // Print the final result
        System.out.println(result);
    }
}