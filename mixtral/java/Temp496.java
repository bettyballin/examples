import java.security.Security;
import java.security.Signature;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp496 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            Signature signature = Signature.getInstance("SHA1withRSA", "BC");
            System.out.println("Signature instance created successfully.");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}