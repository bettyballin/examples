import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Add your custom TokenAuthenticationFilter
        RequestMatcher requiresToken = new AntPathRequestMatcher("/api/**");

        AbstractAuthenticationProcessingFilter tokenAuthFilter =
                new TokenAuthenticationFilter(requiresToken);

        http.addFilterBefore(tokenAuthFilter, UsernamePasswordAuthenticationFilter.class)
            // Enable OAuth 2 SSO
            .antMatcher("/**")
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2Login();
    }
}