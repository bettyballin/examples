import java.security.Security;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp714 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        try {
            Cipher cipher = Cipher.getInstance("RSA/None/OAEPWithSHA1AndMGF1Padding", "BC");
            // Add your encryption/decryption operations here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}