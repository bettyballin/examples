import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.security.core.context.SecurityContextImpl;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomerFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) {
    // nothing here...
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession(true);

    SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    if (sci != null) {
      Object principal = sci.getAuthentication().getPrincipal();
      if (principal instanceof SecureUser) {
        SecureUser user = (SecureUser) principal;
        String url = req.getRequestURI();
        if (!user.getPath().contains(url)) {
          ((HttpServletResponse) response).sendRedirect("http://redirect-URL-Here/");
          return;
        }
      }
    }
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    // nothing here...
  }
  
  private interface SecureUser {
    boolean getPath();
  }
}