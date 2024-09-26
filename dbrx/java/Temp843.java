import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class Temp843 {
    public static void main(String[] args) {
        // Since this code is intended to run in a servlet container, the code snippet below
        // will not run as a standalone application. Instead, it should be executed within the
        // context of a web application. The following code assumes that it is being called
        // within a properly configured Spring MVC environment.

        // Example method to simulate handling a request within a Spring MVC controller
        handleRequest();
    }

    public static void handleRequest() {
        HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession(false);
        if (httpSession != null) {
            String customValue = (String) httpSession.getAttribute("customValue");
            System.out.println("Custom Value: " + customValue);
        } else {
            System.out.println("No session found.");
        }
    }
}