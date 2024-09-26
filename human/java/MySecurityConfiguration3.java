import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

    public MySecurityConfiguration() {
        super(false);
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(Arrays.asList((AuthenticationProvider) new AuthProvider()));
    }

    // Dummy AuthProvider class for compilation
    static class AuthProvider implements AuthenticationProvider {
        @Override
        public Authentication authenticate(Authentication authentication) {
            return null;
        }

        @Override
        public boolean supports(Class<?> authentication) {
            return true;
        }
    }
}