import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RemoteTokenServices remoteTokenService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/**").authenticated()
            .and()
            .requestMatcher(new OAuthRequestedMatcher())
            .anonymous().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests().anyRequest().access("hasRole('ROLE_USER')");
    }

    private static class OAuthRequestedMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            // Implement the logic for matching OAuth requests
            return false; // Replace with actual matching logic
        }
    }
}

@Configuration
public class TokenServiceConfig {

  @Value("${wso2is-url}")
  private String wso2ISUrl;

  @Bean
  public RemoteTokenServices remoteTokenServices() {
      final RemoteTokenServices tokenServices = new RemoteTokenServices();
      tokenServices.setCheckTokenEndpointUrl(this.wso2ISUrl + "/oauth2/token");
      return tokenServices;
   }
}