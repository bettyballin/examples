import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class Temp678 {
    public static void main(String[] args) {
        String password = "yourPasswordHere";
        SecretKey aesKey = new SecretKeySpec(password.getBytes(StandardCharsets.UTF_8), "AES");

        System.out.println("AES Key: " + aesKey);
    }
}