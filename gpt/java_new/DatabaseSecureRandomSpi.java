import java.security.SecureRandomSpi;
import java.util.Random;

public class DatabaseSecureRandomSpi extends SecureRandomSpi {

    private final Random random = new Random();

    @Override
    protected void engineSetSeed(byte[] seed) {
        // Optionally, use the provided seed to reseed the RNG.
        random.setSeed(new SecureRandom(seed).nextLong());
    }

    @Override
    protected void engineNextBytes(byte[] bytes) {
        random.nextBytes(bytes);
    }

    @Override
    protected byte[] engineGenerateSeed(int numBytes) {
        byte[] seed = new byte[numBytes];
        random.nextBytes(seed);
        return seed;
    }
}