import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class OneTimeKeyGenerator {

    public static SecretKey generateOneTimeKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        keyGen.init(256, secureRandom);
        return keyGen.generateKey();
    }

    public static void main(String[] args) {
        try {
            SecretKey oneTimeKey = generateOneTimeKey();
            // Now you can use oneTimeKey in your AES-CTR encryption
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}