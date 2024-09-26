import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientExample {
    public static void main(String[] args) {
        BasicConfigurator.configure(); // Assuming this is a static method in the class BasicConfigurator
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("http://www.example.com");
            HttpResponse response = httpClient.execute(request);
            // Process the response
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}