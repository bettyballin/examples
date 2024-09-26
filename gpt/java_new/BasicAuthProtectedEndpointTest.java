import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicAuthProtectedEndpointTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testBasicAuthProtectedEndpoint() {
        TestRestTemplate basicAuthTemplate = template.withBasicAuth("user", "pass");
        HttpEntity<String> request = new HttpEntity<>("Your request body");

        ResponseEntity<String> response = basicAuthTemplate.exchange("/put", HttpMethod.PUT, request, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        // Perform further assertions...
    }
}