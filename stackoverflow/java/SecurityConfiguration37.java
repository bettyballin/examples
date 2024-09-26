import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.TestConfiguration;

@TestConfiguration
@Order(1)
@Configuration
public class SecurityConfiguration37 extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().requestMatchers(new AntPathRequestMatcher("/**"));
  }

}