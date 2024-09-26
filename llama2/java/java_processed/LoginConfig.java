import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoginConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .formLogin()
      .loginPage("/login")
      .loginProcessingUrl("/j_spring_security_check")
      .defaultSuccessUrl("/MyApplication/account");
  }

  @Bean
  public LoginController loginController() {
    return new LoginController();
  }
}

class LoginController {
  // Define methods for handling login requests if needed
}