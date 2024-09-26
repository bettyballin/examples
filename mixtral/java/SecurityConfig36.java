import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ... other configurations

        http.authorizeRequests()
            .antMatchers("/api/url/available/without/login").permitAll();

        // or

        http.authorizeRequests().anyRequest().authenticated()
                .and()
                    .anonymous().disable()
                    .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
            .and()
            .authorizeRequests().antMatchers("/api/url/available/without/login").permitAll();

        // ... other configurations

    }

    private static class CustomAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(javax.servlet.http.HttpServletRequest request,
                           javax.servlet.http.HttpServletResponse response,
                           org.springframework.security.access.AccessDeniedException accessDeniedException)
                throws java.io.IOException, javax.servlet.ServletException {
            response.sendError(javax.servlet.http.HttpServletResponse.SC_FORBIDDEN, "Access Denied!");
        }
    }
}