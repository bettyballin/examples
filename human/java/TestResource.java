import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
@RequestMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
class TestResource {

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value = "somePath", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object apiEndpoint() {
        return null;
    }
}