import java.security.SecureRandom;
import java.util.Base64;

public class Main1 {
    public static void main(String[] args) {
        SecureRandom rnd = new SecureRandom();
        byte[] password = new byte[18];
        rnd.nextBytes(password);
        String encoded = Base64.getEncoder().encodeToString(password);
        System.out.println(encoded);
    }
}