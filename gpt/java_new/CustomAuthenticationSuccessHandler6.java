import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Component
public class CustomAuthenticationSuccessHandler6 extends SimpleUrlAuthenticationSuccessHandler {

   @Autowired
   private YourCustomService yourCustomService;

   public String getClientIp(HttpServletRequest request) {
       String remoteAddr = "";

       if (request.getHeader("X-Forwarded-For") != null) {
           remoteAddr = request.getHeader("X-Forwarded-For").split(",")[0];
       } else {
           remoteAddr = request.getRemoteAddr();
       }

       return remoteAddr;
   }

   // Other methods and logic for the success handler
}