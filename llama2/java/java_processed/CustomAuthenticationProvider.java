import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private AccessService accessService;

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String requestedPath = authentication.getPrincipal().toString(); // Get the requested path from the principal
        if (!accessService.hasAccess(requestedPath)) {
            throw new AccessDeniedException("User does not have access to this resource");
        }

        return authentication; // Assuming super.authenticate(authentication) was a mistake
    }
}

interface AccessService {
    boolean hasAccess(String path);
}

@Service
class AccessServiceImpl implements AccessService {
    @Override
    public boolean hasAccess(String path) {
        // Implement access logic here
        return true; // Default implementation for demonstration
    }
}

public class Main {
    public static void main(String[] args) {
        // You need a Spring Application to run this, so create an ApplicationConfiguration class
    }
}

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example")
public class ApplicationConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }
}