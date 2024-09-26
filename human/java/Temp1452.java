import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp1452 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("RSA/None/OAEPWithSHA1AndMGF1Padding", "BC");
            System.out.println("Cipher instance created successfully.");
        } catch (NoSuchAlgorithmException | NoSuchProviderException | javax.crypto.NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
}