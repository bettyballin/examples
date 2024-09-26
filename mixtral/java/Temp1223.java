import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

public class Temp1223 {
    public static void main(String[] args) {
        // Example variables to make the code executable
        Boolean logout = true;
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        SessionStatus sessionStatus = null;
        ModelAndView model = new ModelAndView();

        if (logout != null) {
            HttpSession sesion = request.getSession(false);

            if (sessionStatus != null) {
                sessionStatus.setComplete();
            }

            SecurityContextHolder.clearContext();

            if (sesion != null) {
                sesion.invalidate();
            }

            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    cookie.setValue(null);
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }

            model.addObject("msg", "You've been logged out successfully.");
        }
    }
}