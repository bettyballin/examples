import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp591 {

    public static void main(String[] args) {
        Temp591 temp = new Temp591();
        String password = "myPassword123";
        String hashedPassword = temp.hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", 0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}