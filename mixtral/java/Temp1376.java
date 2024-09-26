import javax.net.ssl.*;
import java.net.URL;
import java.security.SecureRandom;

public class Temp1376 {
    public static void main(String[] args) throws Exception {
        String[] ciphers = {"TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"};

        SSLContext sslContext = SSLContext.getInstance("TLS");

        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }
        }};

        sslContext.init(null, trustAllCerts, new SecureRandom());

        URL url = new URL("https://example.com");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        SSLSocketFactory factory = sslContext.getSocketFactory();

        SSLSocket sslSocket = (SSLSocket) factory.createSocket();
        sslSocket.setEnabledCipherSuites(ciphers);

        connection.setSSLSocketFactory(factory);

        // Continue with your request
    }
}