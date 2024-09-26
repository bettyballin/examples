import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

@Service
public class UserDetailsServiceImpl2 implements UserDetailsService {
    // Load user by username and roles
}

@Service
public class CompanyDetailsServiceImpl implements UserDetailsService {
    // Load company by company name
}

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailsServiceImpl2 userDetailsServiceImpl;

    @Autowired
    private CompanyDetailsServiceImpl companyDetailsServiceImpl;

    @Override
    public Authentication authenticate(Authentication authentication) {
        // Your authentication logic here
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Your supports logic here
        return false;
    }
}