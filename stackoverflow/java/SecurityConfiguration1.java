import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Component;
import my.package.CustomUserDetailsService; // Replace with the actual package where CustomUserDetailsService is located

@Component
public class SecurityConfiguration1 {

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public SecurityConfiguration1(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }
}