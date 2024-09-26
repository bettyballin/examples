import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptionKeyGenerator {

    public static void main(String[] args) {
        String password = "secret password";
        byte[] salt = Base64.getDecoder().decode("AAAAAAAAAAAAAAAAAAAAAA==");
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        try {
            // Generate a 32-byte key.
            int keyLength = 32;
            // Adjust the parameters according to the desired variant (minimal, interactive, moderate, sensitive)
            String encryptionKeyBase64 = generateArgon2idKey(argon2, password, salt, keyLength, Argon2Factory.MemoryCost.MINIMAL);
            System.out.println("encryptionKeyArgon2id (Base64) minimal: " + encryptionKeyBase64);

            // Repeat for other variants as needed
        } finally {
            // Wipe confidential data
            argon2.wipeArray(password.toCharArray());
        }
    }

    private static String generateArgon2idKey(Argon2 argon2, String password, byte[] salt, int keyLength, Argon2Factory.MemoryCost preset) {
        // Define parameters based on the preset
        int iterations = preset.getIterations();
        int memory = preset.getMemory();
        int parallelism = preset.getParallelism();

        // Generate the hash
        String hash = argon2.hash(iterations, memory, parallelism, password.toCharArray(), salt, keyLength);

        // Extract the raw hash bytes, skipping the Argon2 hash identifier
        byte[] rawHash = Base64.getDecoder().decode(hash.split("\\$")[5]);

        // Return the key as a base64 encoded string
        return Base64.getEncoder().encodeToString(rawHash);
    }
}