import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// Assuming MyCustomAuthenticationSuccessHandler is in the same package
// or imported accordingly

@Bean
public AuthenticationSuccessHandler mySuccessHandler() {
    return new MyCustomAuthenticationSuccessHandler();
}