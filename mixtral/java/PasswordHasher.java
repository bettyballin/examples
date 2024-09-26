import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHasher {
    public static String sha512Hex(String input) {
        return DigestUtils.sha512Hex(input);
    }

    public static void main(String[] args) {
        String password = "mySecurePassword";
        String hashedPassword = sha512Hex(password);
        System.out.println("Original: " + password);
        System.out.println("Hashed: " + hashedPassword);
    }
}