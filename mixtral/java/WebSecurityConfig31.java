import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2LoginConfigurer;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ClientRegistrationRepository clientRegistrations;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        OAuth2AuthorizationRequestResolver authReqRes = new CustomOAuth2AuthorizationRequestResolver(clientRegistrations, "/oauth2/authorization");

        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .anyRequest().authenticated()
            )
            .oauth2Login(oauth2Login ->
                oauth2Login
                    .authorizationEndpoint(authorizationEndpoint ->
                        authorizationEndpoint
                            .authorizationRequestResolver(authReqRes)
                    )
            );
    }
}

class CustomOAuth2AuthorizationRequestResolver implements OAuth2AuthorizationRequestResolver {
    private final ClientRegistrationRepository clientRegistrations;
    private final String authorizationRequestBaseUri;

    public CustomOAuth2AuthorizationRequestResolver(ClientRegistrationRepository clientRegistrations, String authorizationRequestBaseUri) {
        this.clientRegistrations = clientRegistrations;
        this.authorizationRequestBaseUri = authorizationRequestBaseUri;
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
        // Custom implementation here
        return null;
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
        // Custom implementation here
        return null;
    }
}