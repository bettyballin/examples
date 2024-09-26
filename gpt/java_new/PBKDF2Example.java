import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PBKDF2Example {

    public static byte[] hashPasswordUsingPBKDF2(char[] password, byte[] salt, int iterationCount, int keyLength) 
      throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password, salt, iterationCount, keyLength);
        return factory.generateSecret(spec).getEncoded();
    }
}