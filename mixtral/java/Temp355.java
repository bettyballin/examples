import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp355 extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationManager customAuthenticationManager;

    public static void main(String[] args) {
        // Your main method implementation here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * Do your stuff here
         */
    }

    @Bean("customAuthenticationManager")
    public AuthenticationManager authenticationManager() throws Exception {
        return customAuthenticationManager;
    }

    public class CustomAuthenticationManager implements AuthenticationManager {
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            // Custom authentication logic here
            return null;
        }
    }
}