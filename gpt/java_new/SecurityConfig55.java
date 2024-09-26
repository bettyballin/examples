import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig55urerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig55 extends WebSecurityConfig55urerAdapter {

    private static class CustomLoginUrlAuthenticationEntryPoint implements AuthenticationEntryPoint {
        private final String redirectUrl;

        public CustomLoginUrlAuthenticationEntryPoint(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }

        // Implement required methods for AuthenticationEntryPoint
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/foo/**").authenticated()
                .and()
            .exceptionHandling()
                .defaultAuthenticationEntryPointFor(
                    new CustomLoginUrlAuthenticationEntryPoint("/in_development_page.html"),
                    new AntPathRequestMatcher("/foo/**")
                );
    }
}