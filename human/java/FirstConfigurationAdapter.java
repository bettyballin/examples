import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class MultiHttpSecurityConfig {

    @Order(1)
    @Configuration
    public static class FirstConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // Settings for login page 1 here.
        }
    }

    @Order(2)
    @Configuration
    public static class SecondConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // Settings for login page 2 here.
        }
    }

    // Add more configurations as needed
}