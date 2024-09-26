import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

   private final YourAuditService auditService;

   @Autowired
   public CustomAuthenticationSuccessHandler(YourAuditService auditService) {
       this.auditService = auditService;
   }

   @Override
   public void onAuthenticationSuccess(HttpServletRequest request,
                                       HttpServletResponse response, Authentication authentication) throws IOException {
       String ip = request.getRemoteAddr();
       Date date = new Date();
       UserDetails userDetails = (UserDetails) authentication.getPrincipal();
       auditService.recordLogin(userDetails.getUsername(), ip, date);
       response.sendRedirect(request.getContextPath());
   }
}
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
   // Implementation here
}