import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomOktaAuthenticationProvider implements AuthenticationProvider {

    private final ResourceServerTokenServices tokenServices;
    private final JwtAccessTokenConverter tokenConverter;

    public CustomOktaAuthenticationProvider(ResourceServerTokenServices tokenServices, JwtAccessTokenConverter tokenConverter) {
        this.tokenServices = tokenServices;
        this.tokenConverter = tokenConverter;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Your code to hit Okta introspect endpoint and verify token goes here.
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) tokenServices.loadAuthentication(authentication.getPrincipal().toString());
        // Additional custom validation logic can be added here
        return oAuth2Authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OAuth2Authentication.class.isAssignableFrom(authentication);
    }
}