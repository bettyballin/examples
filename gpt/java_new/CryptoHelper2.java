import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class CryptoHelper2 {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String KEY_ALGORITHM = "AES";
    private static final int IV_LENGTH = 16;
    private static final int SALT_LENGTH = 8;
    private static final int KEY_SIZE = 32;
    private static final String HASH_ALGORITHM = "MD5";
    private static final int ITERATIONS = 1;

    public static String encrypt(String plainText, String password) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        byte[] keyAndIV = generateKeyAndIV(KEY_SIZE, IV_LENGTH, ITERATIONS, salt, password.getBytes());
        byte[] key = Arrays.copyOfRange(keyAndIV, 0, KEY_SIZE);
        byte[] iv = Arrays.copyOfRange(keyAndIV, KEY_SIZE, keyAndIV.length);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, KEY_ALGORITHM), new IvParameterSpec(iv));

        byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));

        byte[] encryptedWithSalt = new byte[salt.length + encrypted.length];
        System.arraycopy(salt, 0, encryptedWithSalt, 0, salt.length);
        System.arraycopy(encrypted, 0, encryptedWithSalt, salt.length, encrypted.length);

        return Base64.getEncoder().encodeToString(encryptedWithSalt);
    }

    private static byte[] generateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password) throws Exception {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);

        int digestLength = md.getDigestLength();
        int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
        byte[] generatedData = new byte[requiredLength];
        int generatedLength = 0;

        try {
            md.reset();
            // First digest
            if (salt != null) {
                md.update(salt, 0, 8);
            }