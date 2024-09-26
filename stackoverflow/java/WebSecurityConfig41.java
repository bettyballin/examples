import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig41urerAdapter;

@Configuration
@EnableWebSecurity
@Profile("!test")
public class WebSecurityConfig41 extends WebSecurityConfig41urerAdapter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig41.class);

    @Value("${server.environment}")
    private String environment;

    @Value("${swagger.user}")
    private String swaggerUser;

    @Value("${swagger.password}")
    private String swaggerPass;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        
        if ("stage".equals(environment) || "prod".equals(environment)) {
            LOGGER.info("Environment: " + environment + " swagger authentication is on");
            http
                .authorizeRequests()
                .antMatchers("/v2/api-docs").authenticated();
        } else {
            http.authorizeRequests().antMatchers("/**").permitAll();
            LOGGER.info("Environment: " + environment + " swagger authentication is off");
        }
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser(swaggerUser).password("{noop}" + swaggerPass).roles("USER");
    }
}