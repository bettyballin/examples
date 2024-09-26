import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig58urerAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;

@EnableWebSecurity
public class WebSecurityConfig58 extends WebSecurityConfig58urerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .addFilterBefore(xyzTokenRequestHeaderAuthenticationFilter(), RequestHeaderAuthenticationFilter.class)
      .csrf().disable()
      .authorizeRequests()
      .requestMatchers(EndpointRequest.to("health", "info")).permitAll()
      .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
      .antMatchers("/actuator/health").permitAll()
      .antMatchers("/actuator/**").permitAll()
      .anyRequest().authenticated()
      .and()
      .authenticationManager(authenticationManager());
  }

  private RequestHeaderAuthenticationFilter xyzTokenRequestHeaderAuthenticationFilter() {
    // Implementation for xyzTokenRequestHeaderAuthenticationFilter
    return new RequestHeaderAuthenticationFilter();
  }

  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    // Provide custom AuthenticationManager if required, otherwise use super
    return super.authenticationManager();
  }
}