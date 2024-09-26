import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig20urerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig20 extends WebSecurityConfig20urerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Your configuration code here
  }
}