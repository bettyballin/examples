import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;

public class OAuthTest {

    @Test
    public void is_status_up() {
        // Given
        final String TOKEN_URL = "http://localhost:8080/oauth/token";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "username");
        params.add("password", "password");
        params.add("grant_type", "password");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        // Rest of the test code
    }
}