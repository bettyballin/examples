import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig4urerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig4 extends WebSecurityConfig4urerAdapter {

  @Bean
  public SAMLWebSSOHoKProcessingFilter samlFilter() throws Exception {
    SAMLWebSSOHoKProcessingFilter samlFilter = new SAMLWebSSOHoKProcessingFilter();
    samlFilter.setAuthenticationManager(authenticationManager());
    // .......
    return samlFilter;
  }

  @Override  
  protected void configure(HttpSecurity http) throws Exception {
      http.addFilterBefore(samlFilter(), BasicAuthenticationFilter.class);
  }
}