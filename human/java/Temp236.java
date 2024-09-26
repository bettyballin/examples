import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.logging.Logger;

public class Temp236 {
    private static final Logger logger = Logger.getLogger(Temp236.class.getName());

    public static void main(String[] args) {
        try {
            TrustManagerFactory tmf = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init((KeyStore) null);
            X509TrustManager xtm = (X509TrustManager) tmf.getTrustManagers()[0];
            for (X509Certificate cert : xtm.getAcceptedIssuers()) {
                String certStr = "S:" + cert.getSubjectDN().getName() + "\nI:"
                        + cert.getIssuerDN().getName();
                logger.info(certStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}