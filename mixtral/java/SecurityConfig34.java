import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Allow access to all endpoints except "/env"
    http
      .authorizeRequests()
        .antMatchers("/actuator/**").permitAll()
        .anyRequest().authenticated();

    // Disable CSRF
    http.csrf().disable();
  }
}