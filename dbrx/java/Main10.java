import java.security.SecureRandom;
import java.util.HexFormat;

public class Main {
    public static void main(String[] args) throws Exception {

        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[32];
        random.nextBytes(bytes);

        String hexString = HexFormat.of().formatHex(bytes);
        System.out.println(hexString);
    }
}