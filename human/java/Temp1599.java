import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Temp1599 {
    public static void main(String[] args) {
        byte[] salt = {1, 2, 3, 4, 5};
        String password = "password";
        byte[] hash = generateHash(password, salt);

        System.out.println(check(hash, password, salt));
    }

    public static boolean check(byte[] hash, String password, byte[] salt) {
        return Arrays.equals(hash, generateHash(password, salt));
    }

    private static byte[] generateHash(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            return md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}