import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Temp1706 {
    public static void main(String[] args) {
        SpringApplication.run(Temp1706.class, args);
    }

    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers("/", "/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
        }
    }

    @Controller
    public class MyController {
        @GetMapping("/secure/xyz")
        public String secureXyz(Authentication authentication) {
            if (authentication == null || !authentication.isAuthenticated()) {
                // User is not authenticated, redirect them somewhere else.
                return "redirect:/login";
            }

            // User is authenticated. Do something here.
            return "secure/xyz";  // or whatever your view name should be
        }

        @GetMapping("/login")
        public String login() {
            return "login";  // Return the login view name
        }
    }
}