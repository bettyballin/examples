import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.context.annotation.Bean;

public class MySecurityConfig {

    private AuthenticationManagerBuilder authenticationBuilder;

    public MySecurityConfig(AuthenticationManagerBuilder authenticationBuilder) {
        this.authenticationBuilder = authenticationBuilder;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationBuilder.build();
    }
}