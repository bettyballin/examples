import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext == null) {
            chain.doFilter(request, response);
            return;
        }

        boolean isLoggedIn = facesContext.getExternalContext().getSessionMap().containsKey("user");

        if (!isLoggedIn) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String loginUrl = httpRequest.getContextPath() + "/login.xhtml";
            if (httpRequest.getMethod().equalsIgnoreCase("GET") && httpRequest.getRequestURI().endsWith("/login.xhtml")) {
                chain.doFilter(request, response);
            } else {
                httpResponse.sendRedirect(loginUrl);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}