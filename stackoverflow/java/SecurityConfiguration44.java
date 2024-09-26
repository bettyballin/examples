import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration44 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/welcome", "/inventory/**", "/sales/**").hasRole("USER")
            .and().exceptionHandling()
                .accessDeniedPage("/403")
            .and().formLogin()
            .and().logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
            .and()
                .csrf()
                    .disable();
    }
}