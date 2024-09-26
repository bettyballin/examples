import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512Hasher {
    public static byte[] hash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        // Convert the input string to a byte array and update it
        md.update(password.getBytes(StandardCharsets.UTF_8));

        return md.digest();
    }

    public static void main(String[] args) {
        try {
            String password = "myPassword";

            // Hash the input string
            byte[] hashedPassword = hash(password);

            System.out.println("Hashed Password:");

            for (byte b : hashedPassword)
                System.out.printf("%02x", Byte.toUnsignedInt(b));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}