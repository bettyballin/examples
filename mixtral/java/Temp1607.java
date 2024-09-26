import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Temp1607 {
    public static void main(String[] args) {
        try {
            String password = "password";
            byte[] salt = "salty".getBytes();
            int iterations = 10000;
            int derivedKeyLength = 256;
            String encryptedPassword = getEncryptedPasswordAsString(password, salt, iterations, derivedKeyLength);
            System.out.println("Encrypted Password: " + encryptedPassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public static String getEncryptedPasswordAsString(String password, byte[] salt, int iterations, int derivedKeyLength)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        return Base64.getEncoder().encodeToString(
                getEncryptedPassword(password, salt, iterations, derivedKeyLength));
    }

    private static byte[] getEncryptedPassword(String password, byte[] salt, int iterations, int derivedKeyLength)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return skf.generateSecret(spec).getEncoded();
    }
}