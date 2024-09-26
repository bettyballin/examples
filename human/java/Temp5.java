import java.security.SecureRandom;
import java.util.Base64;

public class Temp5 {
    public static void main(String[] args) {
        SecureRandom rnd = new SecureRandom();
        /* Byte array length is multiple of LCM(log2(64), 8) / 8 = 3. */
        byte[] password = new byte[18];
        rnd.nextBytes(password);
        String encoded = Base64.getEncoder().encodeToString(password);
        System.out.println(encoded);
    }
}