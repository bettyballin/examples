import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public class AuthenticationController3 {

   @GetMapping("/checkStatus")
   @ResponseBody
   public String checkAuthenticationStatus() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
           return "User is authenticated";
       } else {
           return "User is not authenticated";
       }
   }

   @GetMapping("/profile")
   public String profile(@AuthenticationPrincipal OAuth2User principal) {
       if (principal != null) {
           return "secure/profile";
       } else {
           return "redirect:/login";
       }
   }
}