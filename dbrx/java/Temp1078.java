import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import kong.unirest.Unirest;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.Optional;

public class Temp1078 {
    public static void main(String[] args) {
        // Enable Cookie management (default)
        HttpClient httpClient = HttpClients.createDefault();
        Unirest.setHttpClient(httpClient);

        // Mock of asJson.getHeaders() for demonstration purposes
        Map<String, List<String>> headers = Map.of(
                "Set-Cookie", List.of("JSESSIONID=12345; Path=/; HttpOnly")
        );

        // Or disable and add the JSESSIONID cookie to your request headers.
        Predicate<Map.Entry<String, List<String>>> prdct =
                entry -> "Set-Cookie".equalsIgnoreCase(entry.getKey());

        String jSessionIdCookieValue = headers.entrySet()
                .stream()
                .filter(prdct)
                .findFirst()
                .map(Map.Entry::getValue)
                .map(list -> list.get(0))
                .orElse("");

        Unirest.setDefaultHeader("Cookie", jSessionIdCookieValue.split(";")[0]);
    }
}