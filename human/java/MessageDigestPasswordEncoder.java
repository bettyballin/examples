import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MessageDigestPasswordEncoder extends BaseDigestPasswordEncoder {
    private final String algorithm;
    private int iterations = 1;

    public MessageDigestPasswordEncoder(String algorithm) {
        this.algorithm = algorithm;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    private MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm [" + algorithm + "]", e);
        }
    }

    public String encodePassword(String rawPass, Object salt) {
        String saltedPass = mergePasswordAndSalt(rawPass, salt, false); /* 1 */

        MessageDigest messageDigest = getMessageDigest();

        byte[] digest = messageDigest.digest(Utf8.encode(saltedPass)); /* 2 */

        // "stretch" the encoded value if configured to do so
        for (int i = 1; i < this.iterations; i++) { /* 3 */
            digest = messageDigest.digest(digest);
        }

        if (getEncodeHashAsBase64()) {
            return Utf8.decode(Base64.getEncoder().encode(digest));
        } else {
            return new String(Hex.encode(digest)); /* 4 */
        }
    }

    private String mergePasswordAndSalt(String password, Object salt, boolean strict) {
        if (password == null) {
            password = "";
        }

        if (strict && (salt != null)) {
            if ((salt.toString().lastIndexOf("{") != -1) || (salt.toString().lastIndexOf("}") != -1)) {
                throw new IllegalArgumentException("Cannot use { or } in salt.toString()");
            }
        }

        if ((salt == null) || "".equals(salt)) {
            return password;
        } else {
            return password + "{" + salt.toString() + "}";
        }
    }

    private boolean getEncodeHashAsBase64() {
        // This method should return whether to encode the hash as Base64 or not
        // For demonstration purposes, we will return false.
        return false;
    }

    // Dummy Utf8 class to simulate encoding and decoding
    static class Utf8 {
        public static byte[] encode(String string) {
            return string.getBytes(StandardCharsets.UTF_8);
        }

        public static String decode(byte[] bytes) {
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }

    // Dummy Hex class to simulate hex encoding
    static class Hex {
        public static char[] encode(byte[] bytes) {
            char[] hexChars = new char[bytes.length * 2];
            for (int j = 0; j < bytes.length; j++) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            return hexChars;
        }

        private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    }

    public static void main(String[] args) {
        MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA-256");
        encoder.setIterations(1000);

        String encodedPassword = encoder.encodePassword("password", "salt");
        System.out.println("Encoded Password: " + encodedPassword);
    }
}

// Dummy BaseDigestPasswordEncoder class to simulate superclass
abstract class BaseDigestPasswordEncoder {
    // This class should contain common functionality for all DigestPasswordEncoders
}