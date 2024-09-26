import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

public class Temp1798 {
    
    @Autowired
    private HttpSession httpSession;

    public static void main(String[] args) {
        Temp1798 instance = new Temp1798();
        instance.configureHttpSession(instance.httpSession);
    }

    private void configureHttpSession(HttpSession httpSession) {
        if (httpSession != null) {
            httpSession.setMaxInactiveInterval(24 * 60 * 60); // Set expiration for JSESSIONID to 1 day
        } else {
            System.out.println("HttpSession is null.");
        }
    }
}