import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.SpnegoAuthenticationProcessingFilter;

public class MyConfiguration1 {

    private AuthenticationManager authenticationManager;

    // Assuming constructor or setter injection for the AuthenticationManager
    public MyConfiguration1(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @Bean
    public SpnegoAuthenticationProcessingFilter spnegoAuthenticationProcessingFilter() {
        SpnegoAuthenticationProcessingFilter filter = new SpnegoAuthenticationProcessingFilter();
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }
}