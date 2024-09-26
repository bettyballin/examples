import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig109urerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig109 extends WebSecurityConfig109urerAdapter {

  private BasicAuthenticationEntryPoint basicAuthenticationEntryPoint;
  private static final String ROLE_CLIENT = "CLIENT"; // Assuming ROLE_CLIENT is defined somewhere

  // Inject BasicAuthenticationEntryPoint using constructor or setter
  public void setBasicAuthenticationEntryPoint(BasicAuthenticationEntryPoint basicAuthenticationEntryPoint) {
    this.basicAuthenticationEntryPoint = basicAuthenticationEntryPoint;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .httpBasic().authenticationEntryPoint(basicAuthenticationEntryPoint)
      .and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeRequests()
        .antMatchers("/gpns/rest/sendgpn/**").permitAll()
        .antMatchers("/gpns/rest/gpnfeedback/**").hasAuthority("ROLE_" + ROLE_CLIENT)
        .anyRequest().authenticated();
  }

  // Other configurations and beans

  // You may also need to configure AuthenticationManagerBuilder if you are managing authentication
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // Configure your authentication manager here
  }
}