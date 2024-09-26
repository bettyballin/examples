import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp487 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        System.out.println("BouncyCastle provider added.");
    }
}