import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Temp1577 {
    public static void main(String[] args) {
        // Example usage of eraseSamlCookie method
    }

    public static void eraseSamlCookie(final HttpServletResponse response) {
        final String cookieName = Config.getParameter(Constants.SSO_COOKIE_NAME);

        if (cookieName != null) {
            Cookie cookie = new Cookie(cookieName, "");

            // Set the secure flag to true
            cookie.setSecure(true);

            cookie.setMaxAge(0);

            cookie.setPath("/");

            cookie.setHttpOnly(true);

            response.addCookie(cookie);
        }
    }
}

// Mock classes for Config and Constants to make the code executable
class Config {
    public static String getParameter(String key) {
        // Mock implementation
        if (Constants.SSO_COOKIE_NAME.equals(key)) {
            return "ssoCookie";
        }
        return null;
    }
}

class Constants {
    public static final String SSO_COOKIE_NAME = "ssoCookieName";
}