import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomAuthenticationEntryPoint customAuthEntryPoint;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .exceptionHandling()
        .authenticationEntryPoint(customAuthEntryPoint);

    // Other configurations...
  }

}