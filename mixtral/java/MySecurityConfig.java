import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private MyAuthenticationProvider myAuthProvider;

   @Override
   protected void configure(HttpSecurity http) throws Exception {
        http
            .authenticationProvider(myAuthProvider)
            // other configurations
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin();
    }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(myAuthProvider);
   }
}

class MyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Implement your authentication logic here
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}