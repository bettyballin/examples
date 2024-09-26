import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class Temp3311 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC", BouncyCastleProvider.PROVIDER_NAME);
            System.out.println("KeyPairGenerator initialized successfully.");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}