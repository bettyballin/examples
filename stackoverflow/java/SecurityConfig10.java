import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig10urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig10 extends WebSecurityConfig10urerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/*").hasRole("ANONYMOUS").and().csrf().disable();
  }
}