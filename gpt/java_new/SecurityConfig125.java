import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig125urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig125 extends WebSecurityConfig125urerAdapter {

    @SuppressWarnings("deprecation") // Only for example purposes
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("user").password("pass").roles("ADMIN").and()
            .withUser("user1").password("pass").roles("USER");
    }
}