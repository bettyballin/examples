import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class Temp1926Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp1926Application.class, args);
    }

    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    // Allow access to POST /v1/users/{id}/do
                    .antMatchers(HttpMethod.POST, "/v1/users/**").permitAll()
                    // Require authentication for other requests
                    .anyRequest().authenticated();
        }
    }
}