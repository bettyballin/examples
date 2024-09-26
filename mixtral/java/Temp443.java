import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import java.io.InputStream;
import java.security.KeyStore;

public class Temp443 {
    @Value("${keystore}")
    private Resource keystore;

    @Value("${truststore}")
    private Resource trustStore;

    @Value("${key-password}")
    private String keyPassword;

    @Value("${trust-password}")
    private String trustPassword;

    public static void main(String[] args) {
        Temp443 temp = new Temp443();
        try {
            HttpComponentsMessageSender sender = temp.createHttpComponentsMessageSender();
            // You can use the sender here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HttpComponentsMessageSender createHttpComponentsMessageSender() throws Exception {
        // Configure the HTTP client
        CloseableHttpClient httpClient = HttpClients.custom().build();

        return new HttpComponentsMessageSender(httpClient);
    }

    public void configureSsl(CloseableHttpClient httpClient) {
        try (InputStream keystoreStream = this.keystore.getInputStream();
             InputStream trustStoreStream = this.truststore.getInputStream()) {

            // Load the key store
            KeyStore keyStore = KeyStore.getInstance("PKCS12");

            char[] passwordChars = (keyPassword != null) ? keyPassword.toCharArray() : new char[0];

            keyStore.load(keystoreStream, passwordChars);

            // Load the trust store
            KeyStore truststore = KeyStore.getInstance("JKS");

            char[] trustPasswordChars = (trustPassword != null) ? trustPassword.toCharArray() : new char[0];
            truststore.load(trustStoreStream, trustPasswordChars);

            // Configure SSL using the loaded keystore and truststore
            // This is typically done using an SSLContext
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}