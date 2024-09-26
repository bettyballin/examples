import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// Main Application Class
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}

// Security Configuration Class
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig {
    // Your security configuration here
}

// Controller Class
@RestController
public class MyController {
    
    @Autowired
    private MySecureService mySecureService;

    @RequestMapping(value = "/getActiveSessions/{a}", method = RequestMethod.GET)
    public String getActiveSessions(@PathVariable("a") final String a) {
        return mySecureService.getName(a);
    }
}

// Service Class
class MySecureService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getName(String name) {
        // Your code here
        return "Hello, " + name;
    }
}