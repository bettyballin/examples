import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

public class TokenServiceWSO2 implements ResourceServerTokenServices {

    @Autowired
    private TokenValidatorWSO2 tokenValidatorWSO2;

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        TokenValidationResponse validationResponse = tokenValidatorWSO2.validateAccessToken(accessToken);
        OAuth2Request oAuth2Request = new OAuth2Request(null, null, null, true, validationResponse.getScope(), null, null, null, null);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(validationResponse.getAuthorizedUserIdentifier(), null, null);
        return new OAuth2Authentication(oAuth2Request, authentication);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        throw new UnsupportedOperationException("Not supported: read access token");
    }

}