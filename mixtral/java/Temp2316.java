import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Temp2316 {
    public static void main(String[] args) {
        String sharedSecretKey = "sharedSecretKey";
        String salt = "someSalt";
        int iterations = 65536;
        int keySize = 256;

        try {
            byte[] derivedKey = generateDerivedKey(sharedSecretKey, salt, iterations, keySize);
            System.out.println(Base64.getEncoder().encodeToString(derivedKey));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    private static byte[] generateDerivedKey(String sharedSecretKey, String salt, int iterations, int keySize)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(sharedSecretKey.toCharArray(), salt.getBytes(), iterations, keySize);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return skf.generateSecret(spec).getEncoded();
    }
}