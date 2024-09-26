import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.validation.BindingResult;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

@Controller
public class Temp298 {

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute @Valid UserForm userForm, BindingResult result, ModelMap model, CsrfToken token) {
        // Validate the received CSRF token
        String _csrf = token.getToken();
        if (!token.getToken().equals(_csrf)) {
            throw new InvalidCsrfException("Invalid CSRF Token");
        }

        // Call your web service
        return "success";
    }

    public static void main(String[] args) {
        // Spring Boot application initializer or any other application context loader can go here
    }
}

class UserForm {
    // Assuming this class has some fields with validation annotations
}

class InvalidCsrfException extends RuntimeException {
    public InvalidCsrfException(String message) {
        super(message);
    }
}