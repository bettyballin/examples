import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig140urerAdapter;

@EnableWebSecurity
public class SecurityConfig140 extends WebSecurityConfig140urerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .formLogin(form -> form
        .loginPage("/index?showDialog=true")
        .loginProcessingUrl("/index")
      );
  }
}