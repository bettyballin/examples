import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig93urerAdapter;

@EnableWebSecurity
public class SecurityConfig93 extends WebSecurityConfig93urerAdapter {
  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
          .antMatchers("/api/login", "/api/logout").permitAll()
          .antMatchers("/api/**").authenticated()
          .and()
        .httpBasic();
  }
}