import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Temp1292 {
    public static void main(String[] args) {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }
}