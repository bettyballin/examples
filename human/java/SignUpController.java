import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @RequestMapping(method = RequestMethod.GET)
    public String signUpForm() {
        // Logic for displaying sign-up form
        return "signupForm"; // return the view name
    }

    @RequestMapping(method = RequestMethod.POST)
    public String crearUsuario(HttpServletRequest request, 
                               @RequestParam("username") String username, 
                               @RequestParam("password") String password) {
        // Logic for creating a new user
        // For demonstration, we just print out the username and password.
        // You would typically save these details to a database.
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        
        return "redirect:/signupSuccess"; // redirect to a success page
    }
}