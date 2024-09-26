import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // Get the user details from the authenticated principal.
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;

            if (!userDetails.isAccountNonExpired()) {
                handleRedirect(response, "/account-expired");
            } else if (!userDetails.isEnabled()) {
                handleRedirect(response, "/disabled-account");
            } else if (!userDetails.isCredentialsNonExpired()) {
                handleRedirect(response, "/credentials-expired");
            } else {
                // If none of the above conditions are met, redirect to a default success page.
                handleRedirect(response, "/default-success-page");
            }
        } else {
            // Handle the case when the principal is not an instance of UserDetails
            handleRedirect(response, "/default-success-page");
        }
    }

    private void handleRedirect(HttpServletResponse response, String url) throws IOException {
        response.setStatus(HttpStatus.TEMPORARY_REDIRECT.value());
        response.setHeader("Location", url);
    }
}