import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomTokenStore tokenStore;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // ...

    http.oauth2ResourceServer().tokenStore(this.tokenStore);

   }
}

// Placeholder for CustomTokenStore to make the code executable
class CustomTokenStore {
    // Add implementation details as needed
}