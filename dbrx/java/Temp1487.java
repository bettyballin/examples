import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;

public class Temp1487 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Main method content
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/api/autenticacion/login", "/api/autenticacion/registro").permitAll() // permit all for these endpoints
            .antMatchers("/**") // match any request but only after the previous ones have been checked
            .hasAnyAuthority("ADMINISTRADOR", "USUARIO")
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint(unauthorizedEntryPoint());
    }

    private AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        };
    }
}