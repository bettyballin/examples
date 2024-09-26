import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig49urerAdapter;

public class SecurityConfig49 extends WebSecurityConfig49urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/inner/event/bus").and()
            .authorizeRequests().antMatchers("/inner/service/**").hasRole("USER").and()
            .formLogin().and()
            .logout().logoutSuccessUrl("/").and()
            .httpBasic();
    }
}