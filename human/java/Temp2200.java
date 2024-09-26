import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String apiKey = "your-api-key";
    private final String contentPath = "your-content-path";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new TokenAuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class);

        String contentPathDir = String.format("/%s/**", contentPath);

        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/authorization/**", "/public/**", "/management/**", "/health/**", contentPathDir).permitAll()
                .antMatchers("/**").authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(apiKeyAuthenticationProvider());
    }

    @Bean
    public TokenAuthenticationProvider apiKeyAuthenticationProvider() {
        return new TokenAuthenticationProvider(apiKey);
    }
}

class TokenAuthenticationFilter extends BasicAuthenticationFilter {
    public TokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    // Implement the required filter logic here
}

class TokenAuthenticationProvider extends org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider {
    private final String apiKey;

    public TokenAuthenticationProvider(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    protected void additionalAuthenticationChecks(org.springframework.security.core.userdetails.UserDetails userDetails, org.springframework.security.authentication.UsernamePasswordAuthenticationToken authentication) {
        // Implement your authentication checks here
    }

    @Override
    protected org.springframework.security.core.userdetails.UserDetails retrieveUser(String username, org.springframework.security.authentication.UsernamePasswordAuthenticationToken authentication) throws org.springframework.security.core.AuthenticationException {
        // Implement user retrieval logic here
        return null;
    }
}