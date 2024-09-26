import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class CryptoUtils {
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final int IV_SIZE = 16;
    private static final int SALT_SIZE = 16;
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 256;

    public byte[] encrypt(String data, SecretKey secret) throws Exception {
        IvParameterSpec iv = generateIv();
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);

        cipher.init(Cipher.ENCRYPT_MODE, secret, iv);

        byte[] encryptedData = cipher.doFinal(data.getBytes());

        return combineIvAndEncryptedData(iv, encryptedData);
    }

    public String decrypt(byte[] dataToDecrypt, SecretKey secret) throws Exception {
        IvParameterSpec iv = extractIvFromCombinedData(dataToDecrypt);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);

        cipher.init(Cipher.DECRYPT_MODE, secret, iv);

        byte[] decryptedBytes = cipher.doFinal(extractEncryptedDataFromCombinedData(dataToDecrypt));

        return new String(decryptedBytes);
    }

    private IvParameterSpec generateIv() {
        byte[] iv = new byte[IV_SIZE];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    private byte[] combineIvAndEncryptedData(IvParameterSpec iv, byte[] encryptedData) {
        byte[] combinedData = new byte[IV_SIZE + encryptedData.length];
        System.arraycopy(iv.getIV(), 0, combinedData, 0, IV_SIZE);
        System.arraycopy(encryptedData, 0, combinedData, IV_SIZE, encryptedData.length);
        return combinedData;
    }

    private IvParameterSpec extractIvFromCombinedData(byte[] combinedData) {
        byte[] iv = Arrays.copyOfRange(combinedData, 0, IV_SIZE);
        return new IvParameterSpec(iv);
    }

    private byte[] extractEncryptedDataFromCombinedData(byte[] combinedData) {
        return Arrays.copyOfRange(combinedData, IV_SIZE, combinedData.length);
    }

    public SecretKey generateSecretKey(char[] password) throws Exception {
        byte[] salt = getSalt();
        KeySpec secretKeySpec = new PBEKeySpec(password, salt, ITERATION_COUNT, KEY_LENGTH);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return new SecretKeySpec(secretKeyFactory.generateSecret(secretKeySpec).getEncoded(), "AES");
    }

    private byte[] getSalt() {
        byte[] salt = new byte[SALT_SIZE];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) {
        try {
            CryptoUtils cryptoUtils = new CryptoUtils();
            SecretKey secretKey = cryptoUtils.generateSecretKey("password".toCharArray());

            String originalData = "Hello, World!";
            byte[] encryptedData = cryptoUtils.encrypt(originalData, secretKey);

            String decryptedData = cryptoUtils.decrypt(encryptedData, secretKey);

            System.out.println("Original Data: " + originalData);
            System.out.println("Decrypted Data: " + decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}