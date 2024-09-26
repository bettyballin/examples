import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Main18 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
    }
}