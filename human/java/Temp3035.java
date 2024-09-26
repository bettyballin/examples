import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;

@SpringBootApplication
public class Temp3035 {

    public static void main(String[] args) {
        SpringApplication.run(Temp3035.class, args);
    }

    @TestConfiguration
    static class TestConfig {

        @MockBean
        ReactiveClientRegistrationRepository clientRegistrationRepository;

        @Bean
        public ReactiveClientRegistrationRepository clientRegistrationRepository() {
            return clientRegistrationRepository;
        }
    }
}