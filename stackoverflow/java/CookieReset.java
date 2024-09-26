import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieReset {
    public void resetCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
            }
        }
    }
}