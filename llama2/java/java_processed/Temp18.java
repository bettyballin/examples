import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;

public class Temp18 {
    public static void main(String[] args) throws Exception {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init((KeyStore) null);
        CustomTrustManager ctm = new CustomTrustManager();
        javax.net.ssl.TrustManager[] tms = new javax.net.ssl.TrustManager[1];
        tms[0] = ctm;
    }
}

class CustomTrustManager implements javax.net.ssl.X509TrustManager {
    @Override
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
    }
    @Override
    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
    }
    @Override
    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
    }
}