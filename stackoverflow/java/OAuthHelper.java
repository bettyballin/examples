import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.RequestPostProcessor;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class OAuthHelper {

    @Autowired
    private AuthorizationServerTokenServices tokenService;

    public RequestPostProcessor addBearerToken(final String username, String... authorities) {
        return mockRequest -> {
            OAuth2Request oauth2Request = new OAuth2Request(null, "client-id",
                    null, true, null, null, null, null, null);
            Authentication userAuth = new TestingAuthenticationToken(username, null, authorities);
            OAuth2Authentication oauth2Auth = new OAuth2Authentication(oauth2Request, userAuth);
            OAuth2AccessToken token = tokenService.createAccessToken(oauth2Auth);

            mockRequest.addHeader("Authorization", "Bearer " + token.getValue());
            return mockRequest;
        };
    }
}