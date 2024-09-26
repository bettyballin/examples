import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Main44 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
    }
}