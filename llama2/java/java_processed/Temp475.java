import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Temp475 {
    public static void main(String[] args) {
        // Adds BouncyCastle as a Security Provider
        Security.addProvider(new BouncyCastleProvider());
        
        System.out.println("BouncyCastle provider added successfully.");
    }
}