import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthServiceIntegrationTest {

    @LocalServerPort
    private int port;

    @Value("${security.user.name}")
    private String username;

    @Value("${security.user.password}")
    private String password;

    private RestTemplate template = new TestRestTemplate();

    @Test
    public void testTokenGet() {
        String url = "http://localhost:" + port + "/oauth/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, entity, String.class);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Further assertions...
    }
}