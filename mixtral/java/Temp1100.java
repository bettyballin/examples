import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.SpnegoAuthenticationProcessingFilter;

public class Temp1100 {
    public static void main(String[] args) {
        // Your main method logic here
    }

    @Bean
    public SpnegoAuthenticationProcessingFilter spnegoAuthProcessingFilter(
            @Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager) {
        SpnegoAuthenticationProcessingFilter filter = new SpnegoAuthenticationProcessingFilter();
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }
}