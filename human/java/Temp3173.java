import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManagerBuilder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

public class Temp3173 {
    public static void main(String[] args) {
        Temp3173 temp = new Temp3173();
        temp.configure(auth -> {
            auth.authenticationProvider(temp.authenticationProvider1())
                .authenticationProvider(temp.authenticationProvider2());
        });
    }

    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider1())
            .authenticationProvider(authenticationProvider2());
    }

    @Bean("my-auth-provider-1")
    public DaoAuthenticationProvider authenticationProvider1() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

    @Bean("my-auth-provider-2")
    public DaoAuthenticationProvider authenticationProvider2() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // Dummy user details for demonstration
                return User.withUsername("user")
                        .password("{noop}password")
                        .roles("USER")
                        .build();
            }
        };
    }
}