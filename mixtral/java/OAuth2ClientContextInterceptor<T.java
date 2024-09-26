import org.springframework.beans.factory.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.http.client.support.InterceptingHttpAccessor;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.client.RestOperations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestOperations restTemplate(OAuth2RestTemplate oauth2RestTemplate) {
        return new OAuth2ClientContextInterceptor<>(oauth2RestTemplate);
    }

    private static class OAuth2ClientContextInterceptor<T extends ClientHttpRequestFactory> extends InterceptingHttpAccessor {

        private final OAuth2RestTemplate oauth2RestTemplate;

        public OAuth2ClientContextInterceptor(OAuth2RestTemplate oauth2RestTemplate) {
            this.oauth2RestTemplate = oauth2RestTemplate;
            List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
            interceptors.add(this::intercept);
            setInterceptors(interceptors);
        }

        private ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            OAuth2AccessToken accessToken;
            try {
                accessToken = oauth2RestTemplate.getAccessToken();
            } catch (OAuth2AccessDeniedException e) {
                throw new IOException("Access token denied", e);
            }

            if (accessToken != null && !request.getHeaders().containsKey("Authorization")) {
                request.getHeaders().add("Authorization", "Bearer " + accessToken.getValue());
            }

            return execution.execute(request, body);
        }
    }
}