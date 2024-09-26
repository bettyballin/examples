import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Temp1006 {
    public static void main(String[] args) {
        try {
            String[] input = {"example", "test", "input"};
            byte[] digest = sha256digest16(input);
            System.out.println(Arrays.toString(digest));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static byte[] sha256digest16(String[] list) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        for (String s : list) {
            digest.update(s.getBytes("UTF-8"));
        }

        // so you have 32 bytes here
        byte[] b = digest.digest();

        // you can return it directly or you can cut it to 16 bytes
        return Arrays.copyOf(b, 16);
    }
}