import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Temp2347 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) {
        System.out.println("BouncyCastle provider added.");
    }
}