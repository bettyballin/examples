import javax.servlet.http.Cookie;

public class CookieHelper {
    public static void main(String[] args) {
        Cookie cookie = new Cookie("name", "value");
        cookie.setSecure(true);
        // Additional code to use the cookie as needed
    }
}