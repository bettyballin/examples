import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import kong.unirest.Unirest;

public class Temp1635 {
    public static void main(String[] args) {

        HttpClientBuilder httpClientBuilder = HttpClients.custom()
            .setDefaultCookieSpecRegistry(null);
        Unirest.config().httpClient(httpClientBuilder.build());
    }
}