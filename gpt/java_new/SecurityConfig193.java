import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig193urerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class SecurityConfig193 extends WebSecurityConfig193urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/api/autenticacion/login", "/api/autenticacion/registro", "/usuario/").permitAll()
            .antMatchers("/usuario/**").hasAuthority("ADMINISTRADOR")
            .anyRequest().authenticated();
    }
}