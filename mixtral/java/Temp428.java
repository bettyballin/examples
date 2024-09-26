import java.security.MessageDigest;
import java.util.Base64;

public class Temp428 {
    public static void main(String[] args) {
        try {
            String value = "yourStringHere"; // Replace with your input string
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(value.getBytes("UTF-16LE"));

            // Convert the byte array into a Base64 String
            String base64Hash = Base64.getEncoder().encodeToString(hashBytes);

            System.out.println(base64Hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}