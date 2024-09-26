import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContexts;
import com.nimbusds.jose.util.DefaultResourceRetriever;

public class Temp1637 {
    public static void main(String[] args) throws Exception {
        TrustStrategy trustStrategy = (X509Certificate[] x509Certificates, String s) -> true;
        SSLContext sslContext = SSLContexts.custom()
            .loadTrustMaterial(null, trustStrategy)
            .build();

        HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);

        DefaultResourceRetriever resourceRetriever = new DefaultResourceRetriever(1000, 1000, 0, true, socketFactory);

        System.out.println(resourceRetriever);
    }
}