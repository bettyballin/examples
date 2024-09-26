import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Temp2201 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2201.class, args);
    }

    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests() // require authorization
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // for the CORS preflight check
                .antMatchers("/login", "/api/open/**", "/resources/**").permitAll()  // the open API endpoints and resources
                .antMatchers("/logout", "/api/secured/**").authenticated(); // lock down these endpoints

            // ...additional configurations...
        }
    }

    @RestController
    public class TestController {
        @GetMapping("/api/open/test")
        public String openEndpoint() {
            return "This is an open endpoint.";
        }

        @GetMapping("/api/secured/test")
        public String securedEndpoint() {
            return "This is a secured endpoint.";
        }
    }
}