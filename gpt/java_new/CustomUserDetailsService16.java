import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service("userDetailsService1")
public class CustomUserDetailsService16 implements UserDetailsService {
    // Load user from the first database/table
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implementation code here
        return null;
    }
}

@Service("userDetailsService2")
public class CustomUserDetailsService2 implements UserDetailsService {
    // Load user from the second database/table
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implementation code here
        return null;
    }
}

@Configuration
@Order(1)
@EnableWebSecurity
public class WebSecurityConfig1 extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailsService1")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your configuration here
    }
}