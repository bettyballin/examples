import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class SecurityConfiguration52 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/api/autenticacion/login", "/api/autenticacion/registro", "usuario/").permitAll()
            .antMatchers("/usuario/**").hasAuthority("ADMINISTRADOR")
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint());
    }

    private Object unauthorizedEntryPoint() {
        // You must provide a valid AuthenticationEntryPoint implementation here
        return null;
    }
}