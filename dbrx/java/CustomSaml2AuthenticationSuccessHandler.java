import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.web.authentication.Saml2AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSaml2AuthenticationSuccessHandler implements Saml2AuthenticationSuccessHandler {

    private final SetToken token;

    @Autowired
    public CustomSaml2AuthenticationSuccessHandler(SetToken token) {
        this.token = token;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication, RelyingPartyRegistration relyingPartyRegistration)
            throws IOException, ServletException {
        // Perform your custom logic here.
        token.doFilterInternal(request, response);
    }
}

// Assumed SetToken class for completeness
@Component
class SetToken {

    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Custom logic for setting the token
        response.getWriter().write("Token set successfully");
    }
}