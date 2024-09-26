import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/your-url-pattern").access("hasIpAddress('127.0.0.1') or hasIpAddress('::1')")
            // other url patterns...
            .and().formLogin();
    }

    public static void main(String[] args) {
        // Spring Boot application entry point
        org.springframework.boot.SpringApplication.run(WebSecurityConfig.class, args);
    }
}