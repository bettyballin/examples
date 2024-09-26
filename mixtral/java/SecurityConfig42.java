import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String ROLE_CLIENT = "CLIENT_USER";

    @Autowired
    private DatabaseAuthenticationProvider databaseAuthenticatonProvider;

    @Autowired
    private GpnBasicAuthentiationEntryPoint basicAuthEnticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
            http.authorizeRequests()
                .antMatchers("/gpns/rest/**").authenticated()
                .and().exceptionHandling().accessDeniedHandler(new AccessDeniedHandlerImpl());

        // Require ROLE_CLIENT for gpNFeedback
        registry.antMatchers("/gpns/rest/**").hasRole("ROLE_" + SecurityConfig.ROLE_CLIENT);

        http
            .httpBasic()
            .authenticationEntryPoint(basicAuthEnticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(databaseUserDetailService())
            .passwordEncoder(new BCryptPasswordEncoder());

        super.configure(auth);
    }

    private UserDetailsService databaseUserDetailService() {
        return new DatabaseUserDetailsService();
    }
}

class DatabaseAuthenticationProvider {
    // Implementation for DatabaseAuthenticationProvider
}

class GpnBasicAuthentiationEntryPoint {
    // Implementation for GpnBasicAuthentiationEntryPoint
}

class DatabaseUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implementation for loading user details
        return null;
    }
}