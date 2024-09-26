import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.core.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationServerConfig1urerAdapter;
import org.springframework.http.ResponseEntity;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig1 extends AuthorizationServerConfig1urerAdapter {

    private WebResponseExceptionTranslator<OAuth2Exception> customWebResponseExceptionTranslator() {
        return e -> ResponseEntity
                .status(e.getHttpErrorCode())
                .body(new CustomOauthException(e.getMessage()));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.exceptionTranslator(customWebResponseExceptionTranslator());
    }

    // rest of the authorization server config

    private static class CustomOauthException extends OAuth2Exception {
        public CustomOauthException(String msg) {
            super(msg);
        }
        // rest of the CustomOauthException
    }
}