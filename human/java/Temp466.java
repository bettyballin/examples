import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp466 {
    public static void main(String[] args) {
        try {
            String input = "Hello, world!";
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            System.out.println("SHA-1 hash: " + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}