import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SecurityConfig127 {

    @Bean("my-auth-provider-1")
    public AuthenticationProvider authenticationProvider1(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean("my-auth-provider-2")
    public AuthenticationProvider authenticationProvider2(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    protected void configure(AuthenticationManagerBuilder auth,
                             AuthenticationProvider authenticationProvider1,
                             AuthenticationProvider authenticationProvider2) {
        auth.authenticationProvider(authenticationProvider1)
            .authenticationProvider(authenticationProvider2);
    }
}