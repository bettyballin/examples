import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

public class RefactoredSnippet5 {
    public static void main(String[] args) {
        String tmpSessionId = "exampleSessionId"; // Assuming tmpSessionId is defined somewhere

        byte[] input = null;
        try {
            input = ("X-Session-Id" + tmpSessionId + "test").getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding exception");
            e.printStackTrace();
        }

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] output = messageDigest.digest(input);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}