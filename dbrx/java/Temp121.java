import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class Temp121 {
    public static void main(String[] args) {
        Temp121 temp121 = new Temp121();
        DaoAuthenticationProvider provider = temp121.authProvider();
        System.out.println("DaoAuthenticationProvider created: " + provider);
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new CustomDaoAuthenticationProvider();
        provider.setUserDetailsService(customUserService());
        return provider;
    }

    @Bean
    public UserDetailsService customUserService() {
        // Implement your custom UserDetailsService here
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // Implement your custom user loading logic here
                return null;
            }
        };
    }

    // Assuming CustomDaoAuthenticationProvider extends DaoAuthenticationProvider
    public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {
        // Custom implementation here
    }
}