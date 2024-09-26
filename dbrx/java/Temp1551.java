import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import java.security.Security;

public class Temp1551 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String algorithm = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
        Cipher cipher = Cipher.getInstance(algorithm, "BC");
        System.out.println("Cipher algorithm: " + cipher.getAlgorithm());
    }
}