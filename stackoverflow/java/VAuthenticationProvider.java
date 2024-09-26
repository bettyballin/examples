import com.auth0.jwt.interfaces.JwkProvider;
import com.auth0.spring.security.api.JwtAuthenticationProvider;
import com.auth0.spring.security.api.authentication.PreAuthenticatedAuthenticationJsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class VAuthenticationProvider extends JwtAuthenticationProvider {

    @Autowired
    private VUserDetailsService vUserDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(VAuthenticationProvider.class);

    public VAuthenticationProvider(JwkProvider jwkProvider, String issuer, String audience) {
        super(jwkProvider, issuer, audience);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.debug("*** Processing authentication for token: " + authentication.getName());
        logger.debug("*** Current granted authorities: " + authentication.getAuthorities());
        UserDetails userDetails = vUserDetailsService.loadUserDetails((PreAuthenticatedAuthenticationJsonWebToken) authentication);
        return new PreAuthenticatedAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthenticatedAuthenticationJsonWebToken.class.isAssignableFrom(authentication);
    }
}