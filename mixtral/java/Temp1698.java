import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class Temp1698Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp1698Application.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(auth -> auth
                // Deny access to everything by default
                .anyRequest().denyAll()

                // Allow specific endpoints
                .antMatchers(HttpMethod.GET, "/jobs").hasRole("my_user")
                .antMatchers(HttpMethod.GET, "/desks").hasRole("my_user"));

        return http.build();
    }
}

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(auth -> auth
                // Deny access to everything by default
                .anyRequest().denyAll()

                // Allow specific endpoints
                .antMatchers(HttpMethod.GET, "/jobs").hasRole("my_user")
                .antMatchers(HttpMethod.GET, "/desks").hasRole("my_user"));
    }
}