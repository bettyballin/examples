import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
public class SecurityTestConfig {

    @Bean
    @Primary
    public UserDetailsServiceImpl userDetailsService() {
        return Mockito.mock(UserDetailsServiceImpl.class);
    }

    @Bean
    @Primary
    public JwtAuthenticationProvider jwtAuthenticationProvider() {
        return Mockito.mock(JwtAuthenticationProvider.class);
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return Mockito.mock(DataSource.class);
    }
}

@WebMvcTest(SomeController.class)
@Import({ErrorHandlerConfiguration.class, SecurityTestConfig.class})
class SomeControllerItTest {
    // ... rest of the test
}