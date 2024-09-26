import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;

public class TrustAllCertificates1 implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        // Trust all clients
    }

    @Override
    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        // Trust all servers
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}