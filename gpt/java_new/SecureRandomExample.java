import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class SecureRandomExample {
    public static void main(String[] args) {
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
            byte[] seed = Files.readAllBytes(Paths.get("/dev/urandom"));
            sr.setSeed(seed);
            // Use SecureRandom
        } catch (NoSuchAlgorithmException | NoSuchProviderException | IOException e) {
            e.printStackTrace();
        }
    }
}