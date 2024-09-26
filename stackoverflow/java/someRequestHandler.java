import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;

public ModelAndView someRequestHandler(Principal principal) {
   User activeUser = (User) ((Authentication) principal).getPrincipal();
   // ...
   return new ModelAndView(); // Assuming some view name and model is added here
}