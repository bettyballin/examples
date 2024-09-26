import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp495 {
    public static void main(String[] args) {
        String value = "HelloWorld";
        String salt = "1234";
        String encryptedValue = encrypt(value, salt);
        System.out.println("Encrypted Value: " + encryptedValue);
    }

    public static String encrypt(String value, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(value.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}