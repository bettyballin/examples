import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp623 {

    @Autowired
    private CsrfTokenRepository csrfTokenRepository;

    public static void main(String[] args) {
        // Your main method logic here
    }

    public String generateCSRFToken(HttpServletRequest request) {
        return ((HttpSessionCsrfTokenRepository) csrfTokenRepository).generateToken(request).getToken();
    }

    public void storeCSRFTokensInResponse(String token, HttpServletResponse response) {
        Cookie cookie = new Cookie("XSRF-TOKEN", token);
        // ... configure your cookie

        ((HttpSessionCsrfTokenRepository) csrfTokenRepository).saveToken(null, null, response);
    }
}