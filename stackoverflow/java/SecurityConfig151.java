import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig151urerAdapter;

@EnableWebSecurity
public class SecurityConfig151 extends WebSecurityConfig151urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers("/yolo/**").permitAll()
            .anyRequest().authenticated()
            .and().formLogin()
            .loginPage("/login").permitAll().loginProcessingUrl("/login")
            .and()
            .logout().permitAll();
    }
}