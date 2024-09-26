import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomStringGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    public String generateKBitAlphaNumeric(int k) throws Exception {
        if (k < 0 || k % 8 != 0) {
            throw new IllegalArgumentException("Invalid bit size");
        }

        int byteSize = k / Byte.SIZE;

        // Generate random bytes
        byte[] randomBytes = new byte[byteSize];
        secureRandom.nextBytes(randomBytes);

        BigInteger bigInt = new BigInteger(1, randomBytes).abs();

        StringBuilder sb = new StringBuilder((k + 6) / Byte.SIZE * 2);

        // Convert to base-95 (alpha numeric ASCII characters excluding space and control chars)
        while (bigInt.compareTo(BigInteger.ZERO) > 0) {
            int remainder = bigInt.mod(new BigInteger("95")).intValue();
            sb.append((char) (remainder + '!'));
            bigInt = bigInt.divide(new BigInteger("95"));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        RandomStringGenerator generator = new RandomStringGenerator();
        System.out.println(generator.generateKBitAlphaNumeric(64)); // Example usage
    }
}