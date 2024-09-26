import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1688 extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Temp1688.class);

    public static void main(String[] args) {
        LOGGER.info("Starting application");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("Initialization HTTP configuration");

        // Add this line to permit access to webjars and login resources
        http.authorizeRequests().antMatchers("/webjars/**", "/login**").permitAll();

        http
            .csrf()
                .disable();

        // Additional configuration can be added here
    }
}