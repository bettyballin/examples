import java.math.BigInteger;
import java.security.SecureRandom;

public class SecureDoubleGenerator {
    private static final BigInteger MAX_DOUBLE_BI = BigInteger.valueOf(Double.MAX_VALUE);
    private static final int BITS_IN_LONG = 64; // number of bits in a long

    public double generateSecureDouble() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[BITS_IN_LONG / Byte.SIZE];
        secureRandom.nextBytes(randomBytes);

        BigInteger randomNumberBi = new BigInteger(1, randomBytes);
        if (randomNumberBi.compareTo(MAX_DOUBLE_BI) > 0) {
            // If the generated number is greater than Double.MAX_VALUE
            // we need to reduce it by subtracting a multiple of MAX_DOUBLE_BI.
            BigInteger reductionFactor = randomNumberBi.divide(MAX_DOUBLE_BI);
            BigInteger reducedRandomNumberBi = randomNumberBi.subtract(reductionFactor.multiply(MAX_DOUBLE_BI));
            return reducedRandomNumberBi.doubleValue() / Double.MAX_VALUE;
        } else {
            // If the generated number is less than or equal to Double.MAX_VALUE
            // we can simply divide it by MAX_DOUBLE_BI.
            return randomNumberBi.doubleValue() / Double.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        SecureDoubleGenerator generator = new SecureDoubleGenerator();
        System.out.println(generator.generateSecureDouble());
    }
}