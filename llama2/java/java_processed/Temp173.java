import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Temp173 {

    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        String encodedPassword = encoder.encode("myPassword");
        byte[] salt = encoder.getSalt(encodedPassword);
        
        System.out.println("Encoded Password: " + encodedPassword);
        System.out.println("Salt: " + Base64.getEncoder().encodeToString(salt));
    }
}

class Encoder {

    private static final String SALT_ALGORITHM = "SHA1PRNG";
    private static final String HASH_ALGORITHM = "SHA-256";

    public String encode(String password) {
        byte[] salt = createSalt();
        byte[] hash = hashPassword(password, salt);
        return Base64.getEncoder().encodeToString(hash) + ":" + Base64.getEncoder().encodeToString(salt);
    }

    public byte[] getSalt(String encodedPassword) {
        String[] parts = encodedPassword.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid encoded password format");
        }
        return Base64.getDecoder().decode(parts[1]);
    }

    private byte[] createSalt() {
        try {
            SecureRandom sr = SecureRandom.getInstance(SALT_ALGORITHM);
            byte[] salt = new byte[16];
            sr.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error creating salt", e);
        }
    }

    private byte[] hashPassword(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            md.update(salt);
            return md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}