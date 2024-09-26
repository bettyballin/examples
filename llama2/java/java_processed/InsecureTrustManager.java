import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class InsecureTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
        // Do nothing, accept all certificates
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {
        // Do nothing, accept all certificates
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public static void main(String[] args) {
        InsecureTrustManager trustManager = new InsecureTrustManager();
        System.out.println("InsecureTrustManager is ready to accept all certificates.");
    }
}