import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

public class Main25 {
    public static void main(String[] args) {
        String password = "your-password";
        Charset someCharset = Charset.forName("UTF-8");
        SecretKey aesKey = new SecretKeySpec(password.getBytes(someCharset), "AES");
        // Rest of the code using aesKey...
    }
}