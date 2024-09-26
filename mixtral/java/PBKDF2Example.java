import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.codec.binary.Hex;

public class PBKDF2Example {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = "password";
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        int iterations = 4096;

        // Generate a key with length of 512 bits
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, 512);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        
        System.out.println("Salt: " + Hex.encodeHexString(salt));
        System.out.println("Hash: " + Hex.encodeHexString(hash));
    }
}