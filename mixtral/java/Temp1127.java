import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class Temp1127 {
    public static void main(String[] args) {
        // Main method content
    }

    @RequestMapping(value = "/customLogin", method = RequestMethod.GET)
    public ModelAndView login() {
        // Your code here
        return new ModelAndView("customLogin"); // Assuming you want to return a view named "customLogin"
    }
}

// Update spring-security.xml
/*
<http>
    ...
    <form-login login-page="/customLogin" />
</http>
*/