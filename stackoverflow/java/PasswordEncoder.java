import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class PasswordEncoder {
    private final SaltGenerator saltGenerator;
    private final MessageDigest messageDigest;

    public PasswordEncoder(SaltGenerator saltGenerator, String algorithm) throws NoSuchAlgorithmException {
        this.saltGenerator = saltGenerator;
        this.messageDigest = MessageDigest.getInstance(algorithm);
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        byte[] digested = decode(encodedPassword);
        byte[] salt = Arrays.copyOfRange(digested, 0, saltGenerator.getKeyLength());
        return Arrays.equals(digested, digest(rawPassword.toString().getBytes(), salt));
    }

    private byte[] digest(byte[] rawPassword, byte[] salt) {
        messageDigest.update(salt);
        return messageDigest.digest(rawPassword);
    }

    private byte[] decode(String encodedPassword) {
        // Implementation for decoding the encoded password (e.g., Base64 or Hex decoding)
        // This is a placeholder as the actual decoding logic is not provided
        return encodedPassword.getBytes();
    }
}

interface SaltGenerator {
    int getKeyLength();
}