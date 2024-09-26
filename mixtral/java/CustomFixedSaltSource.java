import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;

public class CustomFixedSaltSource implements SaltSource {
    @Override
    public Object getSalt(UserDetails user) {
        return "fixed_salt";
    }
}

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomFixedSaltSource customFixedSaltSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        // Assuming userDetailsService is defined somewhere
        provider.setUserDetailsService(userDetailsService());

        // Set the password encoder
        PasswordEncoder passwordEncoder = new StandardPasswordEncoder("53cr3t");
        provider.setPasswordEncoder(passwordEncoder);

        // Use our custom salt source
        provider.setSaltSource(customFixedSaltSource);

        auth.authenticationProvider(provider);
    }

    // Dummy method for illustration
    private UserDetailsService userDetailsService() {
        // Define your user details service here
        return null;
    }
}