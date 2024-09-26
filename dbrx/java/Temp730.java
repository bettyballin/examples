import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UsernamePasswordAuthenticationFilter authenticationTokenFilterBean() {
        // Initialize and return the UsernamePasswordAuthenticationFilter
        return new UsernamePasswordAuthenticationFilter();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(
            authenticationTokenFilterBean(),
            UsernamePasswordAuthenticationFilter.class
        ).requestMatcher(
            new NegatedRequestMatcher(
                new AntPathRequestMatcher("/some_endpoint")
            )
        );
    }
}