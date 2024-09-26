import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
public class SecurityConfig {

    @Bean
    public HttpStatusEntryPoint http401EntryPoint() {
        return new HttpStatusEntryPoint(httpCode401());
    }

    @Bean
    public HttpStatus httpCode401() {
        return HttpStatus.UNAUTHORIZED;
    }
}