import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Temp205 {
    public static final String algorithm = "PBKDF2WithHmacSHA512";

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        System.out.println("Algorithm: " + algorithm);
        System.out.println("BouncyCastle provider added.");
    }
}