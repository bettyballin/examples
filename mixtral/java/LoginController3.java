import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/perform_login")
    public String performLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password) throws Exception {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                username, password);

        Authentication authResult = this.authManager.authenticate(token);

        if (authResult != null && authResult.isAuthenticated()) {
            // Handle successful authentication
        } else {
            // Handle failed authentication
        }

        return "redirect:/home";
    }
}