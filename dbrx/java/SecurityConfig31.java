import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyCustomUserDetailsService myCustomUserDetailsService;
    private final CustomUserDetailsChecker customUserDetailsChecker;

    public SecurityConfig(MyCustomUserDetailsService myCustomUserDetailsService, CustomUserDetailsChecker customUserDetailsChecker) {
        this.myCustomUserDetailsService = myCustomUserDetailsService;
        this.customUserDetailsChecker = customUserDetailsChecker;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myCustomUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        provider.setPreAuthenticationChecks(customUserDetailsChecker);

        auth.authenticationProvider(provider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

@Service
public class MyCustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implementation for loadUserByUsername
        return null;
    }
}

@Component
public class CustomUserDetailsChecker implements UserDetailsChecker {

    @Override
    public void check(UserDetails user) {
        // Implementation for check
    }
}