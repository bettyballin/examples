import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfig9uration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig9 extends GlobalMethodSecurityConfig9uration {
    // Additional configuration can be placed here
}

@RestController
public class FooController {

    @GetMapping("/foo/{fooId}")
    @PreAuthorize("@fooSecurityService.canAccess(authentication, #fooId)")
    public Foo getFoo(@AuthenticationPrincipal User user, @PathVariable Long fooId) {
        // Fetch and return the Foo object if the user has access
        return new Foo(); // Placeholder for actual fetching logic
    }
}

@Service
public class FooSecurityService {

    public boolean canAccess(Authentication authentication, Long fooId) {
        // Implement access logic
        return true; // Placeholder for actual access logic
    }
}

class Foo {
    // Foo class implementation
}