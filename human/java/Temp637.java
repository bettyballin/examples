import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

@Configuration
public class OAuth2Configuration {

    @Bean
    public OAuth2AuthenticationEntryPoint oauthAuthenticationEntryPoint() {
        OAuth2AuthenticationEntryPoint entryPoint = new OAuth2AuthenticationEntryPoint();
        entryPoint.setRealmName("theRealm");
        entryPoint.setExceptionRenderer(headerOnlyExceptionRender());
        return entryPoint;
    }

    @Bean
    public OAuth2AuthenticationEntryPoint clientAuthenticationEntryPoint() {
        OAuth2AuthenticationEntryPoint entryPoint = new OAuth2AuthenticationEntryPoint();
        entryPoint.setRealmName("theRealm/client");
        entryPoint.setTypeName("Basic");
        entryPoint.setExceptionRenderer(headerOnlyExceptionRender());
        return entryPoint;
    }

    @Bean
    public OAuth2AccessDeniedHandler oauthAccessDeniedHandler() {
        OAuth2AccessDeniedHandler handler = new OAuth2AccessDeniedHandler();
        handler.setExceptionRenderer(headerOnlyExceptionRender());
        return handler;
    }

    @Bean
    public HeaderOnlyOAuth2ExceptionRenderer headerOnlyExceptionRender() {
        return new HeaderOnlyOAuth2ExceptionRenderer();
    }

    // Assuming HeaderOnlyOAuth2ExceptionRenderer is a class in org.some.nice.code package
    public static class HeaderOnlyOAuth2ExceptionRenderer {
        // Implementation of the renderer
    }
}