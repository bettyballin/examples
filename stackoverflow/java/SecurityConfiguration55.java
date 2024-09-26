import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration55 extends WebSecurityConfigurerAdapter {

    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SecurityConfiguration55.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("Using default configure(HttpSecurity). " +
                "If subclassed this will potentially override subclass configure(HttpSecurity).");
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();
    }
}