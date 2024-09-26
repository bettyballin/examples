import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        RequestMatcher requestMatcher = new AntPathRequestMatcher("/api/**");

        PreAuthenticatedProcessingFilter preAuthFilter = new PreAuthenticatedProcessingFilter();

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken("user", "password");

        TestingAuthenticationProvider testingAuthProvider =
                new TestingAuthenticationProvider(authToken);

        AuthenticationManager authenticationManager =
                new ProviderManager(Arrays.asList(testingAuthProvider));

        preAuthFilter.setAuthenticationManager(authenticationManager);

        http.addFilterBefore(preAuthFilter, AbstractPreAuthenticatedProcessingFilter.class);

        // ...
    }
}

// A mock class for TestingAuthenticationProvider
class TestingAuthenticationProvider extends org.springframework.security.authentication.dao.DaoAuthenticationProvider {

    private final UsernamePasswordAuthenticationToken authToken;

    public TestingAuthenticationProvider(UsernamePasswordAuthenticationToken authToken) {
        this.authToken = authToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    protected void doAfterPropertiesSet() {
        // No-op
    }

    @Override
    public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) {
        if (authToken.getPrincipal().equals(authentication.getPrincipal()) &&
                authToken.getCredentials().equals(authentication.getCredentials())) {
            return authToken;
        } else {
            throw new org.springframework.security.core.AuthenticationException("Authentication failed") {};
        }
    }
}