import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig87urerAdapter;

@EnableWebSecurity
public class SecurityConfig87 extends WebSecurityConfig87urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/login.html", "/admin/logout.html").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "PUBLISHER")
                .anyRequest().authenticated()
            .and()
                .addFilterBefore(preAuthenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/admin/login.html"));
    }

    private AbstractPreAuthenticatedProcessingFilter preAuthenticationFilter() {
        // Implementation of the preAuthenticationFilter
        // This is a placeholder for the actual implementation
        return null;
    }
}