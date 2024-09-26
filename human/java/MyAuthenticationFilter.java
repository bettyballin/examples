import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.web.util.UrlUtils;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationFilter extends GenericFilterBean {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            String currentUrl = UrlUtils.buildRequestUrl((HttpServletRequest) request);
            Usuario usuario = (Usuario) authentication.getPrincipal();
            if ("/activacion".equals(currentUrl) || "/configuracion_modelo".equals(currentUrl)) {
                chain.doFilter(request, response);
                return;
            } else if (usuario.getActivationKey() != null) {
                ((HttpServletResponse) response).sendRedirect("/activacion");
                return;
            } else if (authentication.getAuthorities().contains(AppRole.NUEVO_USUARIO)) {
                ((HttpServletResponse) response).sendRedirect("/configuracion_modelo");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}

// Define your Usuario class
class Usuario {
    private String activationKey;

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }
}

// Define your AppRole class
enum AppRole {
    NUEVO_USUARIO
}