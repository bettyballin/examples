import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp2448 {
    public static void main(String[] args) {
        // Example usage
        UserDetailsService userDetailsService = null;  // Replace with actual UserDetailsService implementation
        PasswordEncoder passwordEncoder = null;  // Replace with actual PasswordEncoder implementation
        AuthenticationManager authManager = new Temp2448().authenticationManager(userDetailsService, passwordEncoder);
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return new ProviderManager(provider);
    }
}