import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Usario usuario = (Usario) authentication.getPrincipal();

        if (!usuario.isEmailConfirmed()) {
            // Redirect to email confirmation page
            response.sendRedirect("/activacion");

        } else if (authentication.getAuthorities().contains(AppRole.NUEVO_USUAURI)) {
            // Redirect to account configuration
            response.sendRedirect("/configuracioon_modelo");

        } else {
            // Default success URL
            response.sendRedirect("/home");
        }
    }
}

class Usario {
    private boolean emailConfirmed;

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    // other properties and methods
}

enum AppRole {
    NUEVO_USUAURI
}