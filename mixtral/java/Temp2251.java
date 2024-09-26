import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp2251 {
    public static void main(String[] args) {
        try {
            MessageDigest hash = MessageDigest.getInstance("MD5");
            byte[] digest = hash.digest("ABCD".getBytes());
            for (byte b : digest) {
                System.out.printf("%02x", b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}