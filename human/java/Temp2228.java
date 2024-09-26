import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;

public class Temp2228 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Typically, Spring Boot applications are started with SpringApplication.run
        // No main method logic is required for Spring Security configuration
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.PUT, "/api/{\\d+}/action/**")
            .access("hasAnyRole('View_account','Search_account')");
    }
}