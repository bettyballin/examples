import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig69urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig69 extends WebSecurityConfig69urerAdapter {

    @Configuration
    @Order(1)
    public static class JWTSecurityConfiguration extends WebSecurityConfig69urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // Your JWT configuration here
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your default configuration here
    }
}