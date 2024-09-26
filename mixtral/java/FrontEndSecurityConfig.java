import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class FrontEndSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("frontend")
    private UserDetailsService frontendUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/app/**")
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin();
    }
}