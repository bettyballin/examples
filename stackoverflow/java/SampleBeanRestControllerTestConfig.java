import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import your.package.TokenProvider; // Replace with the actual package name where TokenProvider is located

@TestConfiguration
public class SampleBeanRestControllerTestConfig {

    @Bean
    public TokenProvider tokenProvider() {
        return new TokenProvider();
    }
}