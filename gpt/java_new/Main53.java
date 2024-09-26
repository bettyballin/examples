import java.security.Security;
import java.security.Signature;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Main53 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        try {
            Signature instance = Signature.getInstance("SHA256withRSAandMGF1", "BC");
            // ... Rest of the code to use the Signature instance
        } catch (Exception e) {
            // Handle exception
        }
    }
}