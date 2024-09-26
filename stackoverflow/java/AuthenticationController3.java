import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController3 {

    private final LoginService loginService;

    public AuthenticationController3(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/loginauth")
    public String authenticateLogin(HttpServletRequest request) {
        loginService.authenticateBlogUser(request.getParameter("email"), request.getParameter("password"));
        return "redirect:/";
    }
}