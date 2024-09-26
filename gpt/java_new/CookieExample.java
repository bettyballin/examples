import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieExample {
    public void addHttpOnlyCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("name", "value");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
}