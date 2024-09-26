import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig40urerAdapter;

@Configuration
@EnableWebSecurity
@Profile("!prod")
public class WebSecurityConfig40 extends WebSecurityConfig40urerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig40.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("Security configuration for the non prod env is loaded");
        http
            .csrf().disable()
            .authorizeRequests().antMatchers("/**").permitAll();
    }
}