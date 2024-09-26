import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class Temp2503 {
    private static final int PBE_ITERATION_COUNT = 10000;
    private static final int AES_KEY_LENGTH_BITS = 128;
    private static final int HMAC_KEY_LENGTH_BITS = 256;
    private static final String PBE_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int AES_KEY_LENGTH_BYTES = AES_KEY_LENGTH_BITS >> 3;
    private static final int HMAC_KEY_LENGTH_BYTES = HMAC_KEY_LENGTH_BITS >> 3;
    private static final String CIPHER = "AES";
    private static final String HMAC_ALGORITHM = "HMACSHA256";
    private static final int MASTER_KEY_LENGTH_BITS = 160; // max for PBKDF2 configured with SHA-1

    public static void main(String[] args) {
        // Test the generateKeyFromPassword method
        try {
            String password = "password";
            byte[] salt = "12345678".getBytes();
            AesHmacKeyPair keyPair = generateKeyFromPassword(password, salt);
            System.out.println("Confidentiality Key: " + Arrays.toString(keyPair.getConfidentialityKey().getEncoded()));
            System.out.println("Integrity Key: " + Arrays.toString(keyPair.getIntegrityKey().getEncoded()));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    public static AesHmacKeyPair generateKeyFromPassword(String password, byte[] salt) throws GeneralSecurityException {
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, PBE_ITERATION_COUNT, MASTER_KEY_LENGTH_BITS);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(PBE_ALGORITHM);
        byte[] masterKeyBytes = keyFactory.generateSecret(keySpec).getEncoded();

        // Generate the AES key
        byte[] confidentialityKeyBytes = kdf(masterKeyBytes, "ENC", AES_KEY_LENGTH_BYTES);
        SecretKey confidentialityKey = new SecretKeySpec(confidentialityKeyBytes, CIPHER);

        // Generate the HMAC key
        byte[] integrityKeyBytes = kdf(masterKeyBytes, "MAC", HMAC_KEY_LENGTH_BYTES);
        SecretKey integrityKey = new SecretKeySpec(integrityKeyBytes, HMAC_ALGORITHM);

        return new AesHmacKeyPair(confidentialityKey, integrityKey);
    }

    private static byte[] kdf(byte[] inputKeyMaterial, String label, int outputKeyBytes) {
        try {
            Mac mac = Mac.getInstance("HMACSHA256");
            mac.init(new SecretKeySpec(inputKeyMaterial, "HMACSHA256"));
            mac.update(label.getBytes(StandardCharsets.US_ASCII));
            byte[] confidentialityKeyBytes = mac.doFinal();
            return Arrays.copyOf(confidentialityKeyBytes, outputKeyBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("HMAC operation doesn't work", e);
        }
    }
}

class AesHmacKeyPair {
    private final SecretKey confidentialityKey;
    private final SecretKey integrityKey;

    public AesHmacKeyPair(SecretKey confidentialityKey, SecretKey integrityKey) {
        this.confidentialityKey = confidentialityKey;
        this.integrityKey = integrityKey;
    }

    public SecretKey getConfidentialityKey() {
        return confidentialityKey;
    }

    public SecretKey getIntegrityKey() {
        return integrityKey;
    }
}