import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfig2urerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpMethod;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig2 extends AuthorizationServerConfig2urerAdapter {

  private TokenStore tokenStore;
  private AccessTokenConverter accessTokenConverter;
  private AuthenticationManager authenticationManager;

  public AuthorizationServerConfig2(TokenStore tokenStore, AccessTokenConverter accessTokenConverter, AuthenticationManager authenticationManager) {
    this.tokenStore = tokenStore;
    this.accessTokenConverter = accessTokenConverter;
    this.authenticationManager = authenticationManager;
  }

  private TokenStore tokenStore() {
    return this.tokenStore;
  }

  private AccessTokenConverter accessTokenConverter() {
    return this.accessTokenConverter;
  }

  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) {
    endpoints
        .pathMapping("/oauth/token", "/api/v1/oauth/token")
        .tokenStore(tokenStore())
        .accessTokenConverter(accessTokenConverter())
        .authenticationManager(authenticationManager)
        .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
  }
}