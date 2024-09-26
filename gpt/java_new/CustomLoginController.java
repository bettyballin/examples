import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import org.springframework.security.core.Authentication;

@Controller
public class CustomLoginController {

    @RequestMapping("/signin")
    public String showLoginPage(Authentication authentication, @RequestParam Optional<String> error, HttpServletRequest request) {
        if (isRememberMeAuthenticated(request)) {
            return "redirect:/home";
        } else if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        return "signin";
    }

    private boolean isRememberMeAuthenticated(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("remember-me".equals(cookie.getName())) {
                    return true;
                }
            }
        }
        return false;
    }
}