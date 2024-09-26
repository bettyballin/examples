import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;

public class Temp2017 {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://example.com";  // replace with the actual URL

        try {
            HttpResponse<String> response = callEndpoint(client, url);

            HttpHeaders headers = response.headers();
            if (headers.map().containsKey("CertificateRequest")) {
                System.out.println("Server supports mutual SSL.");
            } else {
                throw new RuntimeException("Mutual SSL not supported by server!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static HttpResponse<String> callEndpoint(HttpClient client, String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}