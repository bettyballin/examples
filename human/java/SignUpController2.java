import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SignUpController {

    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signUpForm(Model model) {
        // Add attributes to the model if needed
        return "signupForm"; // Return the name of the view (e.g., "signupForm.html")
    }

    @RequestMapping(value="/signup",method=RequestMethod.POST)
    public String crearUsuario(HttpServletRequest request, Model model) {
        // Extract user data from the request and process it
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Perform user creation logic (e.g., save user to the database)
        
        // Add attributes to the model if needed
        model.addAttribute("message", "User created successfully!");
        
        return "signupSuccess"; // Return the name of the view for successful signup
    }
}