import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig17urerAdapter;

public class WebSecurityConfig17 extends WebSecurityConfig17urerAdapter {

   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
           // ... other configurations ...
           .authorizeRequests()
               .antMatchers("/MyService").permitAll()
               // ... other matchers ...
           .and();
           // ... other configurations ...
   }
}