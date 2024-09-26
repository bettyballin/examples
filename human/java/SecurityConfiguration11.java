import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.csrf()

            // Disabling CSRF
            .disable()

            // Disabling Session Management
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and()

            // Adding custom REST Authentication filter
            .addFilterBefore(new RestAuthenticationFilter(authenticationManager()), LogoutFilter.class)

            // Authorizing requests
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .permitAll()
            .antMatchers("/", "/frontend/login")
            .permitAll()
            .antMatchers("/api/**", "/frontend/**")
            .authenticated()
            .antMatchers("/**")
            .permitAll();
    }
}