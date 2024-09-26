import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    //...

    @Bean
    public UsernamePasswordAuthenticationFilter authProcessingFilter() throws Exception {
        return new UsernamePasswordAuthenticationFilter();
    }

    // ...

}