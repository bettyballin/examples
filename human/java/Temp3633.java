import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp3633 {

    private UserDetailsService userDetailService;
    private PasswordEncoder passwordEncoder;

    public Temp3633(UserDetailsService userDetailService, PasswordEncoder passwordEncoder) {
        this.userDetailService = userDetailService;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        // Example usage
        UserDetailsService userDetailsService = null; // You need to provide an actual implementation
        PasswordEncoder passwordEncoder = null; // You need to provide an actual implementation
        Temp3633 temp3633 = new Temp3633(userDetailsService, passwordEncoder);
        AuthenticationManager authenticationManager = temp3633.authenticationManager();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authProvider);
    }
}