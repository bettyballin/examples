import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp1234 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1234.class, args);
    }

    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    // Allow all requests to /health and /info
                    .antMatchers("/health", "/info").permitAll()
                    // Restrict other endpoint access based on IP
                    .and().authorizeRequests()
                        .antMatchers("/**")
                        .access("hasIpAddress('X.X.X.X') or hasIpAddress('Y.Y.Y.Y')");
        }
    }
}