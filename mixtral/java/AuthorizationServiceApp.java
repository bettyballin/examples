import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
@EnableOAuth2Sso
public class AuthorizationServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServiceApp.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
}