import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp959Application {
    public static void main(String[] args) {
        SpringApplication.run(Temp959Application.class, args);
    }
}

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Configure your security here
}

@Component
class Temp959 {
    @PreAuthorize("principal.username == 'desiredUsername'")
    public String restrictedMethod() {
        return "Your code here";
    }
}