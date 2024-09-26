import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CipherFactory {
    public static final String KEY_ALGORITHM = "AES";
    public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    public static Cipher createCipher(int keyId) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        KeyGenerator generator = KeyGenerator.getInstance(KEY_ALGORITHM);
        SecretKey secretKey = generator.generateKey();

        // Replace this with your actual key management logic
        if (keyId == 1) {
            byte[] encodedSecret = Base64.getDecoder().decode("your_base_64_encoded_secret_key");
            secretKey = new SecretKeySpec(encodedSecret, KEY_ALGORITHM);
        } else if (keyId == 2) {
            // Load the second key from a secure storage
            secretKey = loadSecondKey();
        }

        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(new byte[16]);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        return cipher;
    }

    private static SecretKey loadSecondKey() {
        // Replace this with your actual key loading logic
        byte[] encodedSecret = Base64.getDecoder().decode("your_base_64_encoded_second_secret_key");
        return new SecretKeySpec(encodedSecret, KEY_ALGORITHM);
    }

    public static void main(String[] args) {
        try {
            Cipher cipher = createCipher(1);
            System.out.println("Cipher created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}