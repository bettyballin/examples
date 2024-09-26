import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig44urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig44 extends WebSecurityConfig44urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login");
        http.csrf().disable();

        http.authorizeRequests()
            .antMatchers("/index", "/", "/ajouterFiliere").hasAnyRole("RM", "RF")
            .anyRequest().authenticated();

        http.exceptionHandling().accessDeniedPage("/403");
    }
}