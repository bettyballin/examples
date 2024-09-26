import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class EncryptionUtils {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void main(String[] args) {
        // Example usage:
        try {
            String key = "my-super-secret-key";
            File inputFile = new File("document.txt");
            File encryptedFile = new File("document.encrypted");

            byte[] keyBytes = Arrays.copyOf(MessageDigest.getInstance("SHA-1").digest(key.getBytes("UTF-8")), 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] inputBytes = Files.readAllBytes(inputFile.toPath());
            byte[] outputBytes = cipher.doFinal(inputBytes);

            Files.write(encryptedFile.toPath(), outputBytes);
            System.out.println("Encryption completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}