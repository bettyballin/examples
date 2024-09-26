import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Temp3228 {

    public static void main(String[] args) {
        SpringApplication.run(Temp3228.class, args);
    }

    @Component
    public class MyComponent {

        @PreAuthorize("hasAuthority('ROLE_USER')")
        public void myMethod() {
            System.out.println("Executing myMethod with ROLE_USER authority");
        }
    }

    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        // Configure security settings here
    }
}