import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Temp3184 {

    private final LoginService loginService;

    public Temp3184(LoginService loginService) {
        this.loginService = loginService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp3184.class, args);
    }

    @PostMapping("/loginauth")
    public String authenticateLogin(HttpServletRequest request) {
        loginService.authenticateBlogUser(request.getParameter("email"), request.getParameter("password"));
        return "redirect:/";
    }
}

interface LoginService {
    void authenticateBlogUser(String email, String password);
}