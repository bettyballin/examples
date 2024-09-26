import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Temp748 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        System.out.println("BouncyCastle provider added successfully.");
    }
}