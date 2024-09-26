import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private SAMLEntryPoint samlEntryPoint;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers("/saml*").permitAll()
        .anyRequest().authenticated()
        .and()
      .csrf()
        .disable()
      .httpBasic()
        .authenticationEntryPoint(samlEntryPoint);
  }
}