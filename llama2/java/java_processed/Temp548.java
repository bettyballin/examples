import java.security.Security;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

public class Temp548 {
    public static void main(String[] args) throws Exception {
        // Add FIPS provider
        Security.addProvider(new sun.security.provider.Sun());

        // Configure the SSL context
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init((KeyStore) null);
        TrustManager[] trustManagers = tmf.getTrustManagers();

        javax.net.ssl.SSLContext context = javax.net.ssl.SSLContext.getInstance("TLS");
        context.init(null, trustManagers, null);

        // Output a success message
        System.out.println("FIPS provider added and SSL context initialized.");
    }
}