import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

public class RestClientConfig {

    private RestTemplate restTemplate;
    private ClientHttpRequestInterceptor globalOAuthTokenInterceptor;

    public RestClientConfig(ClientHttpRequestInterceptor globalOAuthTokenInterceptor) {
        this.restTemplate = new RestTemplate();
        this.globalOAuthTokenInterceptor = globalOAuthTokenInterceptor;
        configureInterceptors();
    }

    private void configureInterceptors() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(globalOAuthTokenInterceptor);
        restTemplate.setInterceptors(interceptors);
    }
    
    // Other configuration methods...
}