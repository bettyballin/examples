import org.springframework.security.crypto.password.PasswordEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacSha512PasswordEncoder implements PasswordEncoder {
    private final String secretKey;

    public HmacSha512PasswordEncoder(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest((secretKey + rawPassword).getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

    public static void main(String[] args) {
        HmacSha512PasswordEncoder encoder = new HmacSha512PasswordEncoder("mySecretKey");
        String rawPassword = "myPassword";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
        System.out.println("Password matches: " + encoder.matches(rawPassword, encodedPassword));
    }
}