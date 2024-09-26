import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Usuario) {
            String currentUrl = UrlUtils.buildRequestUrl((HttpServletRequest) request);
            Usuario usuario = (Usuario) authentication.getPrincipal();

            if ("/activacion".equals(currentUrl) || "/configuracion_modelo".equals(currentUrl)) {
                chain.doFilter(request, response);
            } else if (usuario.getActivationKey() != null) {
                ((HttpServletResponse) response).sendRedirect("/activacion");
            } else if (authentication.getAuthorities().stream()
                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(AppRole.NUEVO_USUARIO.name()))) {
                ((HttpServletResponse) response).sendRedirect("/configuracion_modelo");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    // Assuming Usuario and AppRole classes are defined somewhere with the correct methods
    public static class Usuario {
        public String getActivationKey() {
            // dummy implementation
            return null;
        }
    }

    public enum AppRole {
        NUEVO_USUARIO
    }
}