import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class Temp100 {
    public static void main(String[] args) {
        AxisEngine engine = new AxisEngine();
        engine.setTrustManager(new TrustAllCerts());
    }
}

class AxisEngine {
    private X509TrustManager trustManager;

    public void setTrustManager(X509TrustManager trustManager) {
        this.trustManager = trustManager;
    }
}

class TrustAllCerts implements X509TrustManager {
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
    }
}