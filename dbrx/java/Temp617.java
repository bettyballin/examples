import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Temp617 {
    public static void main(String[] args) {
        // Example usage
        byte[] dbHash = new byte[0]; // Placeholder for actual dbHash
        String password = "examplePassword";
        byte[] salt = new byte[0]; // Placeholder for actual salt

        try {
            boolean result = check(dbHash, password, salt);
            System.out.println("Password match: " + result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public static boolean check(byte[] dbHash, String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return Arrays.equals(dbHash, generateHash(password, salt));
    }

    private static byte[] generateHash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        return f.generateSecret(spec).getEncoded();
    }
}