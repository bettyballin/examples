import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Temp1611 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        BouncyCastleProvider bcp = new BouncyCastleProvider();
        Security.insertProviderAt(bcp, 1);
    }
}