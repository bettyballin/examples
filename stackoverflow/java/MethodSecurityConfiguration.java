import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;

@Configuration
@EnableGlobalMethodSecurity
class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    return new OAuth2MethodSecurityExpressionHandler();
  }
}

@Configuration
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  // ...
}

@Configuration
@Import({ SecurityConfiguration.class, MethodSecurityConfiguration.class })
class AppConfiguration {
  // ...
}