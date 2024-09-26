import org.bouncycastle.crypto.prng.SP800SecureRandom;
import org.bouncycastle.crypto.prng.drbg.EntropySource;
import org.bouncycastle.crypto.prng.drbg.EntropySourceProvider;

import java.security.SecureRandom;

public class SecureRNG {

    private static class BasicEntropySourceProvider implements EntropySourceProvider {
        private final SecureRandom secureRandom;

        BasicEntropySourceProvider(SecureRandom secureRandom) {
            this.secureRandom = secureRandom;
        }

        @Override
        public EntropySource get(final int bitsRequired) {
            return new EntropySource() {
                @Override
                public boolean isPredictionResistant() {
                    return true;
                }

                @Override
                public byte[] getEntropy() {
                    byte[] entropy = new byte[(bitsRequired + 7) / 8];
                    secureRandom.nextBytes(entropy);
                    return entropy;
                }

                @Override
                public int entropySize() {
                    return bitsRequired;
                }
            };
        }
    }

    private static final SP800SecureRandom SECURE_RANDOM;

    static {
        SecureRandom secureRandom = new SecureRandom();
        EntropySourceProvider entropySourceProvider = new BasicEntropySourceProvider(secureRandom);
        SECURE_RANDOM = new SP800SecureRandom(entropySourceProvider.get(256), true);
    }

    public byte[] generateRandomBytes(int length) {
        byte[] randomBytes = new byte[length];
        SECURE_RANDOM.nextBytes(randomBytes);
        return randomBytes;
    }

    public static void main(String[] args) {
        SecureRNG rng = new SecureRNG();
        byte[] randomBytes = rng.generateRandomBytes(16);
        for (byte b : randomBytes) {
            System.out.printf("%02x", b);
        }
        System.out.println();
    }
}