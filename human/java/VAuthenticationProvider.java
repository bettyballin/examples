import com.auth0.jwk.JwkProvider;
import com.auth0.spring.security.api.authentication.JwtAuthenticationProvider;
import com.auth0.spring.security.api.authentication.PreAuthenticatedAuthenticationJsonWebToken;
import com.auth0.spring.security.api.authentication.PreAuthenticatedAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class VAuthenticationProvider extends JwtAuthenticationProvider {

    @Autowired
    VUserDetailsService vUserDetailsService;

    Logger logger = LoggerFactory.getLogger(VAuthenticationProvider.class);

    public VAuthenticationProvider(JwkProvider jwkProvider, String issuer, String audience) {
        super(jwkProvider, issuer, audience);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.debug("*** Processing authentication for token: " + authentication.getName());
        logger.debug("*** Current granted authorities: " + authentication.getAuthorities());
        UserDetails userDetails = vUserDetailsService.loadUserDetails((PreAuthenticatedAuthenticationJsonWebToken) authentication);
        authentication = new PreAuthenticatedAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(PreAuthenticatedAuthenticationJsonWebToken.class);
    }
}