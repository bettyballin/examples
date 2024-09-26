import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Temp718 {
    public static void main(String[] args) {
        try {
            String secretKey = "fruit";
            String salt = "car29";

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digestOfPassword = md.digest((secretKey + salt).getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOfRange(digestOfPassword, 0, 32), "AES");

            System.out.println("SecretKeySpec: " + secretKeySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}