import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SSLContext;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class CustomTrustManager implements X509TrustManager {
    private final X509Certificate[] trustedRoots;

    public CustomTrustManager(X509Certificate... trustedRoots) {
        this.trustedRoots = trustedRoots;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        // Implement the logic to check client certificates
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        // Implement the logic to check server certificates
        for (X509Certificate cert : chain) {
            boolean trusted = false;
            for (X509Certificate trustedRoot : trustedRoots) {
                try {
                    cert.verify(trustedRoot.getPublicKey());
                    trusted = true;
                    break;
                } catch (Exception e) {
                    // Verification failed, continue checking other trusted roots
                }
            }
            if (!trusted) {
                throw new CertificateException("Certificate is not trusted");
            }
        }
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return trustedRoots;
    }

    public static void main(String[] args) throws Exception {
        // Load the trusted root certificates
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate trustedRoot = (X509Certificate) cf.generateCertificate(
                CustomTrustManager.class.getResourceAsStream("/path/to/trustedRoot.crt"));

        // Create the custom trust manager
        CustomTrustManager customTrustManager = new CustomTrustManager(trustedRoot);

        // Create SSLSocketFactory with the custom trust manager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{customTrustManager}, null);
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Create OkHttpClient with the custom trust manager
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory, customTrustManager)
                .build();

        // Use the client for your requests
    }
}

class CustomSSLSocketFactory {
    private final SSLSocketFactory sslSocketFactory;

    public CustomSSLSocketFactory(TrustManager trustManager) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{trustManager}, null);
        this.sslSocketFactory = sslContext.getSocketFactory();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return sslSocketFactory;
    }
}