import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.authentication.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
public class CASWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //disable HTTP Session management
        http
            .securityContext()
            .securityContextRepository(new NullSecurityContextRepository())
            .and()
            .sessionManagement().disable();

        http.requestCache().requestCache(new NullRequestCache());

        //no security checks for health checks
        http.authorizeRequests().antMatchers("/health/**").permitAll();

        http.csrf().disable();

        http
            .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint());

        http // login configuration
            .addFilter(authenticationFilter())
            .authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        // return your AuthenticationEntryPoint implementation
        return new CustomAuthenticationEntryPoint();
    }

    @Bean
    public UsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
        // return your UsernamePasswordAuthenticationFilter implementation
        UsernamePasswordAuthenticationFilter filter = new CustomUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    // CustomAuthenticationEntryPoint class implementation
    public static class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(javax.servlet.http.HttpServletRequest request,
                             javax.servlet.http.HttpServletResponse response,
                             org.springframework.security.core.AuthenticationException authException) throws java.io.IOException, javax.servlet.ServletException {
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
    }

    // CustomUsernamePasswordAuthenticationFilter class implementation
    public static class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
        // You can override necessary methods here
    }
}