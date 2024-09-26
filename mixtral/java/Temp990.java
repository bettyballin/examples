import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class YourTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    public void testSecureUrl() {
        rest = rest.withBasicAuth("user", "password");
        ResponseEntity<String> response =
            rest.getForEntity("/your-secure-url/", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}