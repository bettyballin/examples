import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class OtpEncryptionExample {
    private static final int KEY_SIZE = 128; // in bits e.g 128 or higher for AES.
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int IV_SIZE = 12; // Initialization Vector (IV) of size 96-bits.

    public static void main(String[] args) throws Exception {
        SecretKey secretKey = generateSecretKey();
        String otpValue = generateOtp();
        byte[] iv = generateIV();

        System.out.println("Original OTP: " + otpValue);
        byte[] encryptedBytes = encrypt(secretKey, iv, otpValue.getBytes());
        System.out.println("Encrypted OTP (Base64): " + Base64.getEncoder().encodeToString(encryptedBytes));
    }

    private static SecretKey generateSecretKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(KEY_SIZE);
        return keyGen.generateKey();
    }

    private static String generateOtp() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    private static byte[] generateIV() {
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[IV_SIZE];
        random.nextBytes(iv);
        return iv;
    }

    private static byte[] encrypt(SecretKey secretKey, byte[] iv, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
        return cipher.doFinal(data);
    }
}