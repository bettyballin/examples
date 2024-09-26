import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ClinicService clinicService;

    // ... other methods ...

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(clinicService);
    }
}

// Assuming ClinicService and CustomUserDetailsService are defined somewhere in the project

@Service
public class ClinicService {
    // Implementation of ClinicService
}

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ClinicService clinicService;

    @Autowired
    public CustomUserDetailsService(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implementation of user details retrieval
        return null;
    }
}


Note: Renamed the method `myCustomUserDetailsService` to `userDetailsService` to override the default `userDetailsService` bean defined by Spring Security.