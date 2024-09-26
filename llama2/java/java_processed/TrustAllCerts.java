import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class TrustAllCerts implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] xcs, String string) {}

    @Override
    public void checkServerTrusted(X509Certificate[] xcs, String string) {}

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public static void main(String[] args) {
        TrustAllCerts trustAllCerts = new TrustAllCerts();
        System.out.println("TrustAllCerts implementation is ready.");
    }
}