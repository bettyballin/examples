import java.security.SecureRandom;

public class SecureRandomDouble {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static double nextSecureDouble() {
        // Generate a random long value
        long randomBits = secureRandom.nextLong();

        // Mask the exponent to a reasonable range to avoid NaN, Infinity, and nonzero values
        long exponentMask = 0x3ffL << 52; // 10 bits for the exponent
        long exponentBits = (randomBits & exponentMask) | (0x3ffL << 52); // Set exponent to 1023

        // Mask the mantissa (lower 52 bits)
        long mantissaMask = (1L << 52) - 1;
        long mantissaBits = randomBits & mantissaMask;

        // Combine the exponent and mantissa bits to form a double
        double result = Double.longBitsToDouble(exponentBits | mantissaBits);

        // Ensure the result is between 0.0 and 1.0
        return (result - 1.0);
    }
}