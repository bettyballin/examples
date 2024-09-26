import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.context.request.RequestContextListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableOAuth2Client
@SpringBootApplication
public class OAuthClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthClientApplication.class, args);
    }

    @Configuration
    public class OAuthClientConfig {

        @Autowired
        AuthorizationServerConfig authorizationServerConfig;

        @Bean
        @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
        public OAuth2RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext) {
            AccessTokenRequest atr = new DefaultAccessTokenRequest();
            return new OAuth2RestTemplate(authorizationServerConfig.getOwnerPasswordResource(), oauth2ClientContext);
        }

        @Bean
        public OAuth2ClientContext oauth2ClientContext() {
            return new DefaultOAuth2ClientContext();
        }

        @Bean
        public RequestContextListener requestContextListener() {
            return new RequestContextListener();
        }

        @Bean
        public OAuth2ClientContextFilter oauth2ClientContextFilter() {
            return new OAuth2ClientContextFilter();
        }
    }

    @Configuration
    public class AuthorizationServerConfig {

        @Bean
        public OAuth2ProtectedResourceDetails getOwnerPasswordResource() {
            // Configure and return the OAuth2ProtectedResourceDetails bean here
            return null;
        }
    }
}