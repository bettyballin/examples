import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig131urerAdapter;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfig131 extends WebSecurityConfig131urerAdapter {

    private final ClientRegistrationRepository clientRegistrationRepository;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    public SecurityConfig131(ClientRegistrationRepository clientRegistrationRepository,
                          AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.clientRegistrationRepository = clientRegistrationRepository;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login(oauth2Login ->
            oauth2Login.authorizationEndpoint()
                .authorizationRequestResolver(
                    new YourCustomAuthorizationRequestResolver(clientRegistrationRepository)
                )
                .and()
                .successHandler(authenticationSuccessHandler)
        );
    }

    private static class YourCustomAuthorizationRequestResolver implements 
        OAuth2AuthorizationRequestResolver {

        private final ClientRegistrationRepository clientRegistrationRepository;

        public YourCustomAuthorizationRequestResolver(ClientRegistrationRepository clientRegistrationRepository) {
            this.clientRegistrationRepository = clientRegistrationRepository;
        }

        @Override
        public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
            // Your custom implementation here
            return null;
        }

        @Override
        public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
            // Your custom implementation here
            return null;
        }
    }
}