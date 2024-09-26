import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import android.util.Log;

public class TrustManagerExample {
    private static final String TAG = "TrustManagerExample";

    public static void main(String[] args) {
        try {
            TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init((KeyStore) null);
            X509TrustManager xtm = (X509TrustManager) tmf.getTrustManagers()[0];
            for (X509Certificate cert : xtm.getAcceptedIssuers()) {
                String certStr = "S:" + cert.getSubjectDN().getName() + "
I:"
                                    + cert.getIssuerDN().getName();
                Log.d(TAG, certStr);
            }
        } catch (Exception e) {
            Log.e(TAG, "An error occurred", e);
        }
    }
}