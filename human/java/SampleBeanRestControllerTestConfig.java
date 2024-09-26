import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TestConfiguration
public class SampleBeanRestControllerTestConfig {

    @Bean
    public TokenProvider tokenProvider() {
        return new TokenProvider();
    }

}

class TokenProvider {
    // Assume there are some methods and properties here
}