import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {

    @Autowired
    private CsrfTokenRepository csrfTokenRepository;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/security/csrf")
    public CsrfToken getCsrfToken() {
        // Generate a new CSRF token here or retrieve it from the HttpSession if you've already generated one.
        return csrfTokenRepository.loadToken(request);
    }
}