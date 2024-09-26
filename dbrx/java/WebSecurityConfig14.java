import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // Custom success handler bean
    public AuthenticationSuccessHandler customSuccessHandler() {
        return new SimpleUrlAuthenticationSuccessHandler("/default");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/action-required").permitAll()  // Allow access to the action required screen without authentication.
                .anyRequest().authenticated()

            .and()
                .formLogin()
                    .loginPage("/login")
                    .successHandler(customSuccessHandler())

            .and()
                .sessionManagement()
                    .invalidSessionUrl("/logout")  // Redirect users with invalid sessions (e.g expired or tampered) to the logout page.
                    .maximumSessions(1)
                        .maxSessionsPreventsLogin(true);
    }
}