import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtils {

    public static String generateSaltedHash(String password, byte[] salt) {
        return DigestUtils.sha256Hex(salt).concat(DigestUtils.sha256Hex(password));
    }

    public static boolean checkPassword(String hashedPassword, String attemptedPassword, byte[] salt) {
        String attemptedHash = DigestUtils.sha256Hex(salt).concat(DigestUtils.sha256Hex(attemptedPassword));
        return hashedPassword.equals(attemptedHash);
    }
}