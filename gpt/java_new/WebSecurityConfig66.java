import org.springframework.security.core.AuthenticationException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig66urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig66 extends WebSecurityConfig66urerAdapter {

    @Override
    protected void configure(HttpSecurity httpSec) throws Exception {
        httpSec
                .authorizeRequests()
                .antMatchers("/users").authenticated()
                .antMatchers("/admin", "/db").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(401, "You have to log in to see this content"))
                .and()
                .logout().logoutSuccessUrl("/login?logout").permitAll();

        httpSec.csrf().disable();
        httpSec.headers().frameOptions().disable();
    }
}

class CustomAuthenticationException extends AuthenticationException {
    public CustomAuthenticationException(String msg) {
        super(msg);
    }
}