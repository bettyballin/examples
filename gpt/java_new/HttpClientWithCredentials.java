import org.apache.http.auth.AuthScope;
import org.apache.http.auth.CredentialsProvider;
import org.apache.http.auth.NTCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

public class HttpClientWithCredentials {
    public static void main(String[] args) {
        // Set credentials
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
            new AuthScope("192.168.1.116", 8080), // Replace with your proxy port if different
            new NTCredentials("username", "password", "workstation", "domain")
        );

        // Create an HttpClient with the credentials provider
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder.setDefaultCredentialsProvider(credsProvider);
        CloseableHttpClient httpClient = clientBuilder.build();

        // Use the httpClient instance for your requests
        // ...
    }
}