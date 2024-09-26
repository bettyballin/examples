import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.context.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2AccessTokenSupport;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

@Component
public class Temp2272 {

    @Resource(name = "accessTokenRequest")
    private OAuth2AccessTokenSupport accessTokenRequest;

    @Bean
    @Qualifier("facebookClientContext")
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

    @Bean
    public OAuth2RestTemplate sparklrRestTemplate(
            @Qualifier("oauth2ClientContext") OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(sparklr(), clientContext);
    }

    @Bean
    public OAuth2RestTemplate sparklrRedirectRestTemplate(
            @Qualifier("oauth2ClientContext") OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(sparklrRedirect(), clientContext);
    }

    private OAuth2ProtectedResourceDetails facebook() {
        // Provide implementation for facebook OAuth2ProtectedResourceDetails
        return null;
    }

    private OAuth2ProtectedResourceDetails sparklr() {
        // Provide implementation for sparklr OAuth2ProtectedResourceDetails
        return null;
    }

    private OAuth2ProtectedResourceDetails sparklrRedirect() {
        // Provide implementation for sparklrRedirect OAuth2ProtectedResourceDetails
        return null;
    }

    public static void main(String[] args) {
        // Code to run the application
    }
}