import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import static org.assertj.core.api.Assertions.assertThat;

public class StatusTest {

    @Test
    public void is_status_up() throws InterruptedException {
        // Given
        final String TOKEN_URL = "http://localhost:8080/oauth/token";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "<your-username>");
        params.add("password", "<your-credentials>");
        params.add("grant_type", "password");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("<client-id>", "<client-secret>"));

        // When
        String result = null;
        try {
            result = restTemplate.postForObject(TOKEN_URL, request, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException | ResourceAccessException | RestClientException e) {
            e.printStackTrace();
        }

        // Then
        assertThat(result).isNotNull();
    }
}