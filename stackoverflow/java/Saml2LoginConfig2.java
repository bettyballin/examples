import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.saml2.provider.service.authentication.OpenSamlAuthenticationProvider;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticationToken;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Saml2LoginConfig2 {
    public void setup() {
        new ProviderManager(Collections.singletonList(
                new OpenSamlAuthenticationProvider() {{
                    setResponseAuthenticationConverter(new Function<Saml2AuthenticationToken, Authentication>() {
                        @Override
                        public Authentication apply(Saml2AuthenticationToken token) {
                            // Assuming createDefaultResponseAuthenticationConverter() and other methods are defined elsewhere
                            Authentication defaultAuth = OpenSamlAuthenticationProvider.createDefaultResponseAuthenticationConverter().convert(token);
                            if (defaultAuth != null && defaultAuth.isAuthenticated()) {
                                // Implement your logic to extract authorities here
                                List<Object> authoritiesList = Collections.emptyList(); // replace with actual authorities extraction
                                return new Saml2Authentication(defaultAuth.getPrincipal(), token.getSaml2Response(), authoritiesList);
                            }
                            return defaultAuth;
                        }
                    });
                }}
        ));
    }
}