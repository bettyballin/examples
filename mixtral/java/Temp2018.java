import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2018 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method content if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ... other configurations

        http
            .authorizeRequests()
            .antMatchers("/v3/api-docs/**", "/swagger-ui.html**").permitAll();

        // ... more configurations
    }
}