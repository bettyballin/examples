import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final OAuth2AuthenticationEntryPoint authenticationEntryPoint;
    private final ClientDetailsService clientDetailsService;
    private final TokenStore tokenStore;
    private final UserApprovalHandler userApprovalHandler;

    public OAuth2AuthConfig(@Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager,
                            OAuth2AuthenticationEntryPoint authenticationEntryPoint,
                            @Qualifier("clientDetailsService") ClientDetailsService clientDetailsService,
                            TokenStore tokenStore,
                            UserApprovalHandler userApprovalHandler) {
        this.authenticationManager = authenticationManager;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.clientDetailsService = clientDetailsService;
        this.tokenStore = tokenStore;
        this.userApprovalHandler = userApprovalHandler;
    }
}