import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Temp2964 {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        ClientHttpRequestInterceptor globalOAuthTokenInterceptor = (request, body, execution) -> {
            // Add your interceptor logic here
            return execution.execute(request, body);
        };
        interceptors.add(globalOAuthTokenInterceptor);
        restTemplate.setInterceptors(interceptors);
        // Example usage
        // restTemplate.getForObject("http://example.com", String.class);
    }
}