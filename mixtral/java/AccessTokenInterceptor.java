import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class AccessTokenInterceptor implements ClientHttpRequestInterceptor {

    private String token;

    public void setAccessToken(String token) {
        this.token = token;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        if (token != null && !token.isEmpty()) {
            request.getHeaders().set("Authorization", "Bearer " + token);
        }
        return execution.execute(request, body);
    }

    public static void main(String[] args) {
        AccessTokenInterceptor interceptor = new AccessTokenInterceptor();
        interceptor.setAccessToken("YOUR_ACCESS_TOKEN");
        // Here you can add code to test the interceptor with a RestTemplate or any HTTP client.
    }
}