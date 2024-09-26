import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class SessionTokenAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String header = request.getHeader("SESSION_TOKEN");

        if (header == null || "".equals(header))
            return null;

        // Perform token validation and extract username
        String extractedUsernameFromTokenValidation = validateAndExtractUsername(header);

        return extractedUsernameFromTokenValidation;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        String header = request.getHeader("SESSION_TOKEN");

        if (header == null || "".equals(header))
            return null;

        // Perform token validation and extract credentials
        String extractedCredentialFromTokenValidation = validateAndExtractCredentials(header);

        return extractedCredentialFromTokenValidation;
    }

    private String validateAndExtractUsername(String token) {
        // Dummy implementation for validation and extraction of username
        // Replace this with actual token validation logic
        return "extractedUsername";
    }

    private String validateAndExtractCredentials(String token) {
        // Dummy implementation for validation and extraction of credentials
        // Replace this with actual token validation logic
        return "extractedCredentials";
    }
}