import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;

@Component
@EnableOAuth2Client
public class OAuth2ClientConfig {

    @Resource(name = "accessTokenRequest")
    private AccessTokenRequest accessTokenRequest;

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public DefaultOAuth2ClientContext facebookClientContext() {
        return new DefaultOAuth2ClientContext(accessTokenRequest);
    }

    @Bean
    public OAuth2RestTemplate facebookRestTemplate(
            @Qualifier("facebookClientContext") OAuth2ClientContext clientContext) {
        OAuth2RestTemplate template = new OAuth2RestTemplate(facebook(), clientContext);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(
                Arrays.asList(MediaType.APPLICATION_JSON, MediaType.valueOf("text/javascript")));
        template.setMessageConverters(Arrays.<HttpMessageConverter<?>>asList(converter));
        return template;
    }

    // Assume that the facebook(), sparklr(), and sparklrRedirect() methods are defined elsewhere
}