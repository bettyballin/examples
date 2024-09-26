import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Temp37 {

    public static void main(String[] args) {
        // This main method can be used for testing purposes if required
    }

    public void removeJSessionIdCookie(HttpServletResponse response) {
        Cookie jsessionid = new Cookie("JSESSIONID", null);
        jsessionid.setMaxAge(0); // expires the cookie immediately
        jsessionid.setPath("/"); // set path to root so it applies everywhere

        response.addCookie(jsessionid);
    }
}