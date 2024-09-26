import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class UserController5 {

  @Autowired
  private MyUserDetailsService userDetailsService;

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public UserView home(Principal principal) {
      if (principal != null) {
          User user = userDetailsService.loadUserByUsername(principal.getName());
          return new UserView(user);
      } else {
          return null;
      }
  }
}