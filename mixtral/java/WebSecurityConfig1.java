import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfig1 {

    private final UserDetailsService userDetailsService;

    public WebSecurityConfig1(@Qualifier("customUserDetailsService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

   // ...
}

@Configuration
public class WebSecurityConfig2 {

    private final UserDetailsService adminUserDetailsService;

    public WebSecurityConfig2(@Qualifier("adminCustomUserDetailsService") UserDetailsService adminUserDetailsService) {
        this.adminUserDetailsService = adminUserDetailsService;
    }

   // ...
}