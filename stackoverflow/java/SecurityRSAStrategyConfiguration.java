import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableWebSecurity
@ImportResource({"classpath*:spring-security-RSA.xml"})
public class SecurityRSAStrategyConfiguration {
    // ...
}