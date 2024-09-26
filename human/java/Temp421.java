import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class Temp421 {
    public static void main(String[] args) {
        // Your code here
    }

    public static class MyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // Implementation here
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // Implementation here
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}