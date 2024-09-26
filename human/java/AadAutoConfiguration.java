import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@SpringBootApplication
public class AadAutoConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AadAutoConfigurationApplication.class, args);
    }
}

@Configuration(proxyBeanMethods = false)
@Import({AadPropertiesConfiguration.class})
class AadAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(JwtDecoder.class)
    public JwtDecoder jwtDecoder(RestTemplateBuilder restTemplateBuilder,
                                 AadAuthenticationProperties aadAuthenticationProperties) {
        AadResourceServerConfiguration configuration = new AadResourceServerConfiguration(restTemplateBuilder);
        return configuration.jwtDecoder(aadAuthenticationProperties);
    }
}

// Mock classes for compilation
class AadPropertiesConfiguration {
}

class AadResourceServerConfiguration {

    private final RestTemplateBuilder restTemplateBuilder;

    public AadResourceServerConfiguration(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public JwtDecoder jwtDecoder(AadAuthenticationProperties aadAuthenticationProperties) {
        // Mock implementation
        return null;
    }
}

class AadAuthenticationProperties {
}