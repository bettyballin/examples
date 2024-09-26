import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Temp1452 {
    public static void main(String[] args) {
        try {
            byte[] secret = "mysecret".getBytes();
            byte[] salt = "mysalt".getBytes();
            byte[] derivedKey = deriveAes256bitKey(secret, salt);
            System.out.println(java.util.Arrays.toString(derivedKey));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    private static byte[] deriveAes256bitKey(byte[] secret, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec keySpec = new PBEKeySpec(new String(secret).toCharArray(), salt, 1024, 256);
        SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
        return secretKey.getEncoded();
    }
}