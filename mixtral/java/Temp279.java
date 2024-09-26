import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp279 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        // The following line is incorrect and does not compile
        // JceSecurity.setVerificationResult("BC", true);
        // Instead, if you need to verify the provider, you can check as follows:
        if (Security.getProvider("BC") != null) {
            System.out.println("BouncyCastle provider is set.");
        } else {
            System.out.println("Failed to set BouncyCastle provider.");
        }
    }
}