import javax.net.ssl.*;
import java.security.cert.X509Certificate;

public class TrustAllCertificates3 implements X509TrustManager, HostnameVerifier {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
        // Trust without verification
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {
        // Trust without verification
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0]; // Trust all issuers
    }

    @Override
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}