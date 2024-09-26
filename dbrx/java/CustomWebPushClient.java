import javax.net.ssl.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

public class CustomWebPushClient extends WebPushClient {
    @Override
    protected SSLSocketFactory createSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {

        SSLContext sslContext = SSLContext.getInstance("TLS");
        TrustManager[] trustManagers = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType)
                            throws CertificateException {

                        // Implement your custom validation logic here
                        if (!isValidPushServer(certs)) {
                            throw new CertificateException("Invalid push server certificate");
                        }
                    }
                }
        };
        sslContext.init(null, trustManagers, null);
        return sslContext.getSocketFactory();
    }

    private boolean isValidPushServer(X509Certificate[] certs) throws CertificateEncodingException {
        // Implement your custom validation logic here
        // Example: simply return true for demonstration purposes
        return true;
    }
}

class WebPushClient {
    protected SSLSocketFactory createSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        // Default implementation (if any)
        return null;
    }
}

Note: I added `@Override` annotations to the methods in the `X509TrustManager` implementation. This is not strictly necessary, but it's a good practice to include these annotations when overriding methods from a superclass or interface.