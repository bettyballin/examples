import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SecurityProviderCheck {
    public static void main(String[] args) {
        if (Security.getProvider("BC") == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }
}