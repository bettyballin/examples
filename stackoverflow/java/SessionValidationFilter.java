import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.BadCredentialsException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SessionValidationFilter extends GenericFilterBean {

  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String AUTHORIZATION_BEARER = "Bearer";

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

    String jwt = getTokenFromRequest(httpServletRequest);
    if (jwt == null) {
       filterChain.doFilter(servletRequest, servletResponse);
       return;
    }

    if (!this.validateToken(jwt)) {
      throw new BadCredentialsException("Session expired");
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  private String getTokenFromRequest(HttpServletRequest request){
    String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(AUTHORIZATION_BEARER + " ")) {
      return bearerToken.substring(7);
    }
    return null;
  }

  private boolean validateToken(String token) {
    try {
      Claims claims = Jwts.parser()
        .parseClaimsJws(token)
        .getBody();

      String sessionId = claims.get("sessionid", String.class);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}