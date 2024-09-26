import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@ImportResource({"classpath*:spring-security-RSA.xml"})
public class SecurityRSAStrategyConfiguration {
    // Add your security configuration here
}