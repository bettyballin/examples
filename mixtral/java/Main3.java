import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.security.KeyStore;

public class Main {
    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");

        try (FileInputStream inputStream = new FileInputStream("<path_to>/keystore.jks")) {
            keyStore.load(inputStream, "<password>".toCharArray());

            SSLContext sslcontext = SSLContexts.custom()
                    .loadKeyMaterial(keyStore, "<password>".toCharArray())
                    .build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslcontext,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());

            try (CloseableHttpClient httpclient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .build()) {

                HttpPost httpPost = new HttpPost("<https://your-api-endpoint>");

                try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
                    HttpEntity entity = response.getEntity();
                    System.out.println(EntityUtils.toString(entity));
                }
            }
        }
    }
}