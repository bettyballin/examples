import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig134urerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1000)
public class SecurityConfig134 extends WebSecurityConfig134urerAdapter {
    // Overriding some of the configuration methods if necessary
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        // Custom configuration can go here
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        // Custom authentication configuration can go here
    }
}

@RestController
public class YourController {

    private final AccessService accessService;

    @Autowired
    public YourController(AccessService accessService) {
        this.accessService = accessService;
    }

    @PreAuthorize("@accessService.hasAccess(#requestedPath)")
    @GetMapping("/{requestedPath}")
    public ResponseEntity<?> getSomething(@PathVariable String requestedPath) {
        // Controller logic goes here
        return ResponseEntity.ok("Data for " + requestedPath);
    }
}