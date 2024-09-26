// Without the context of the rest of the code, it's impossible to refactor the snippet accurately.
// However, I can provide a template that would typically be used in a Spring Security configuration.

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig139urerAdapter;

public class SecurityConfig139 extends WebSecurityConfig139urerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers("/public/**").permitAll()
        .anyRequest().authenticated()
      .and()
      .formLogin()
        .loginPage("/login").permitAll()
      .and()
      .logout()
        .permitAll();
  }
}