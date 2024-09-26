import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Temp1436 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1436.class, args);
    }

    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests(auth -> auth
                    // Allow access to specific URLs
                    .antMatchers("/", "/index", "/static/**", "/assets/**").permitAll()
                    // Require authentication for all other requests
                    .anyRequest().authenticated()
                )
                // Configure login and logout
                .formLogin(login -> login
                    .loginPage("/login")
                    .defaultSuccessUrl("/dashboard", false)
                    .permitAll()
                )
                // Allow HTTP Basic authentication
                .httpBasic();
        }
    }
}