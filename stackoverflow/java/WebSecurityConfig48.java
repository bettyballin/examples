import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfig48 {

  @Value("${security.form.login-url}")
  private String loginUrl;

  @Value("${security.form.login-success-url}")
  private String loginSuccessUrl;
  // ...

}