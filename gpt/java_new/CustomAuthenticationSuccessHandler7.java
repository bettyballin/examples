import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler7 implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // Assume Usuario is a valid class that has been defined elsewhere
        Usuario usuario = (Usuario) authentication.getPrincipal();

        if (usuario.getActivationKey() != null) {
            response.sendRedirect("/activacion");
        } else if (usuario.isNuevoUsuario()) {
            response.sendRedirect("/configuracion_modelo");
        } else {
            response.sendRedirect("/default");
        }
    }
}