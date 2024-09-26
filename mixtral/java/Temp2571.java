import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

public class Temp2571 {
    public static void main(String[] args) {
        try {
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init((KeyStore) null);
            sslcontext.init(null, tmf.getTrustManagers(), null);

            HostnameVerifier hv = new HostnameVerifier() {
                @Override
                public boolean verify(String urlHostName, SSLSession session) {
                    return true;
                }
            };

            // Additional code that uses sslcontext and hv can be added here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}