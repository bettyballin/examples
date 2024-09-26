import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authenticationProvider(new AuthenticatedPrincipalAuthenticationProvider());
    }

    public class AuthenticatedPrincipalAuthenticationProvider implements AuthenticationProvider {

        @Override
        public boolean supports(Class<?> aClass) {
            return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
        }

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            // Here you can set the principal object to your custom model
            Object user = new CustomUser(); // Replace with actual user retrieval logic

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null);

            return auth;
        }
    }

    // Dummy CustomUser class to demonstrate the custom principal
    public static class CustomUser {
        // Add your custom user fields and methods here
    }
}