import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // ...

    JwtCookieTokenExtractorFilter jwtCookieTokenExtractorFilter = new JwtCookieTokenExtractorFilter();

    http.addFilterBefore(jwtCookieTokenExtractorFilter, BasicAuthenticationFilter.class);
  }
}

class JwtCookieTokenExtractorFilter extends BasicAuthenticationFilter {
  // Implement the necessary methods for JwtCookieTokenExtractorFilter
}