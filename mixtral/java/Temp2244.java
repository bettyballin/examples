import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class Temp2244 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method implementation here if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers("/api/autenticacion/login", "/api/autenticacion/registro").permitAll()
            .antMatchers("usuario/**").hasAnyRole("ADMINISTRATOR")
            .anyRequest().authenticated();
    }
}