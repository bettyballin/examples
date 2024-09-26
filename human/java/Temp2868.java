import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Temp2868 {

    public static void main(String[] args) {
        String payload = "Sample payload";
        try {
            EncryptedData encryptedData = encrypt(payload.getBytes());
            System.out.println("Payload: " + encryptedData.getPayload());
            System.out.println("IV: " + encryptedData.getIv());
            System.out.println("Key: " + encryptedData.getKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EncryptedData encrypt(byte[] payload) throws Exception {
        SecureRandom secureRandom = new SecureRandom();

        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();

        // Generate IV
        byte[] iv = new byte[12]; // GCM recommended IV size is 12 bytes
        secureRandom.nextBytes(iv);

        // Initialize Cipher
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);
        byte[] encryptedBytes = cipher.doFinal(payload);

        // Extract GCM tag
        int tagLength = 16; // GCM tag length is 16 bytes
        byte[] encryptedPayload = new byte[encryptedBytes.length - tagLength];
        byte[] tag = new byte[tagLength];
        System.arraycopy(encryptedBytes, 0, encryptedPayload, 0, encryptedPayload.length);
        System.arraycopy(encryptedBytes, encryptedPayload.length, tag, 0, tag.length);

        // Combine encrypted payload and tag
        byte[] encryptedLoad = new byte[encryptedPayload.length + tag.length];
        System.arraycopy(encryptedPayload, 0, encryptedLoad, 0, encryptedPayload.length);
        System.arraycopy(tag, 0, encryptedLoad, encryptedPayload.length, tag.length);

        // Convert to Base64
        String base64EncryptedLoad = Base64.getUrlEncoder().encodeToString(encryptedLoad);
        String base64Iv = Base64.getUrlEncoder().encodeToString(iv);
        String base64Key = Base64.getUrlEncoder().encodeToString(key.getEncoded());

        return new EncryptedData(base64EncryptedLoad, base64Iv, base64Key);
    }

    public static class EncryptedData {
        private final String payload;
        private final String iv;
        private final String key;

        public EncryptedData(String payload, String iv, String key) {
            this.payload = payload;
            this.iv = iv;
            this.key = key;
        }

        public String getPayload() {
            return payload;
        }

        public String getIv() {
            return iv;
        }

        public String getKey() {
            return key;
        }
    }

    // Placeholder for RSA encryption method
    public static String RSAencrypt(byte[] key) {
        // Implement RSA encryption here
        // This is a placeholder method for demonstration purposes
        return Base64.getEncoder().encodeToString(key);
    }
}