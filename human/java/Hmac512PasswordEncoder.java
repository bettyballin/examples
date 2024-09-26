import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Hmac512PasswordEncoder {

    private static final String SSHA512_PREFIX = "{SSHA-512}";
    private static final String HMAC_SHA512 = "HmacSHA512";

    private final String salt;

    public Hmac512PasswordEncoder(String salt) {
        if (salt == null) {
            throw new IllegalArgumentException("salt cannot be null");
        }
        this.salt = salt;
    }

    public String encode(CharSequence rawPassword) {
        String result = null;

        try {
            Mac sha512Hmac = Mac.getInstance(HMAC_SHA512);
            final byte[] byteKey = salt.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA512);
            sha512Hmac.init(keySpec);
            byte[] macData = sha512Hmac.doFinal(rawPassword.toString().getBytes(StandardCharsets.UTF_8));

            result = SSHA512_PREFIX + Base64.getEncoder().encodeToString(macData);
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null || encodedPassword == null) {
            return false;
        }

        String encodedRawPass = encode(rawPassword);

        return MessageDigest.isEqual(encodedRawPass.getBytes(StandardCharsets.UTF_8), 
                                     encodedPassword.getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        String salt = "my_salt";
        Hmac512PasswordEncoder encoder = new Hmac512PasswordEncoder(salt);

        String rawPassword = "password123";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("Encoded Password: " + encodedPassword);
        System.out.println("Password matches: " + encoder.matches(rawPassword, encodedPassword));
    }
}