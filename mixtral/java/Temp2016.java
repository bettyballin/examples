import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import java.util.logging.Logger;

public class Temp2016 {

    private static final Logger LOG = Logger.getLogger(Temp2016.class.getName());

    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse response = callEndpoint(httpClient, "http://example.com");
            System.out.println("Response: " + response.getStatusLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HttpResponse callEndpoint(CloseableHttpClient httpclient, String url) {
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            LOG.info("Response Code: " + response.getStatusLine().getStatusCode());
            return response;
        } catch (Exception ex) {
            System.out.println("Boom we failed: " + ex);
            throw new RuntimeException(ex);
        }
    }
}