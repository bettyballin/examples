import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Main70 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        // Your code here
    }
}