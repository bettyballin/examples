import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

public class Temp38 {
    public static void main(String[] args) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream("path_to_your_truststore"), "password".toCharArray());

            SSLContext sslcontext = SSLContexts.custom()
                .loadTrustMaterial(keyStore, new TrustSelfSignedStrategy())
                .build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);

            CloseableHttpClient httpclient = HttpClientBuilder.create()
                .setSSLSocketFactory(sslsf)
                .build();

            // Use the httpclient instance to execute requests

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}