import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Temp740 {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@ModelAttribute("user") User u, Model model, HttpServletRequest request) {
        AuthenticationException exception = (AuthenticationException) request
                .getSession()
                .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        if (exception != null && !StringUtils.isEmpty(exception.getMessage())) {
            // Handle the exception message
            model.addAttribute("errorMessage", exception.getMessage());
        }

        return "loginPage"; // return the login page view name
    }

    public static void main(String[] args) {
        // Spring Boot application entry point
        org.springframework.boot.SpringApplication.run(Temp740.class, args);
    }
}

class User {
    // User class implementation
}