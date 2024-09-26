import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.SecureRandom;
import java.security.Security;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Temp523 {
    public static void main(String[] args) {
        try {
            // Register Bouncy Castle as JCE provider (if not already done)
            Security.addProvider(new BouncyCastleProvider());

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, new SecureRandom());
            SSLSocketFactory factory = (SSLSocketFactory) sslContext.getSocketFactory();

            System.out.println("SSL Socket Factory created successfully.");

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }
}