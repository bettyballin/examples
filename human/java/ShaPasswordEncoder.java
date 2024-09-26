import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaPasswordEncoder extends MessageDigestPasswordEncoder {
    public ShaPasswordEncoder() {
        this(1);
    }

    public ShaPasswordEncoder(int strength) {
        super("SHA-" + strength);
    }

    public static void main(String[] args) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        String encodedPassword = encoder.encode("myPassword");
        System.out.println("Encoded Password: " + encodedPassword);
    }
}

class MessageDigestPasswordEncoder {
    private final String algorithm;

    public MessageDigestPasswordEncoder(String algorithm) {
        this.algorithm = algorithm;
    }

    public String encode(CharSequence rawPassword) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] digest = messageDigest.digest(rawPassword.toString().getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Invalid algorithm: " + algorithm, e);
        }
    }
}