import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig81urerAdapter;

public class SecurityConfig81 extends WebSecurityConfig81urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/*").hasRole("USER")
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true);
    }
}