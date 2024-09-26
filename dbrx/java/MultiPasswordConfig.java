import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class MultiPasswordConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Regular password authentication provider
        DaoAuthenticationProvider regularAuthProvider = new DaoAuthenticationProvider();
        regularAuthProvider.setUserDetailsService(userService);
        regularAuthProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        auth.authenticationProvider(regularAuthProvider);

        // Override password authentication provider
        DaoAuthenticationProvider overrideAuthProvider = new DaoAuthenticationProvider();
        overrideAuthProvider.setUserDetailsService(new UserOverridePasswordService());  // Implement your own service for overriding passwords here.
        overrideAuthProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        auth.authenticationProvider(overrideAuthProvider);
    }

}

class UserOverridePasswordService implements UserDetailsService {
    @Override
    public User loadUserByUsername(String username) {
        // Implement your logic for loading a user with overridden password here
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User("overrideUser", "overridePassword", authorities);
    }
}