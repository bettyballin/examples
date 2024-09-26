import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hmac512PasswordEncoder {

    private static final String HMAC_SHA512 = "HmacSHA512";
    private final String salt;

    public Hmac512PasswordEncoder(String salt) {
        if (salt == null) {
            throw new IllegalArgumentException("salt cannot be null");
        }
        this.salt = salt;
    }

    public String encode(CharSequence rawPassword) {
        try {
            Mac sha512Hmac = Mac.getInstance(HMAC_SHA512);
            final byte[] byteKey = salt.getBytes("UTF-8");
            SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA512);
            sha512Hmac.init(keySpec);
            byte[] macData = sha512Hmac.doFinal(rawPassword.toString().getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(macData);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate HMAC", e);
        }
    }
}