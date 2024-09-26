import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;

public class Temp495 {

    public static void main(String[] args) {
        Temp495 temp495 = new Temp495();
        // Example usage
        HttpServletRequest request = null; // Replace with actual HttpServletRequest instance
        String result = temp495.getActuator(request);
        System.out.println(result);
    }

    @Secured("hasAnyRole('ROLE_USER')")
    public String getActuator(HttpServletRequest request) {
        // code
        return "Actuator accessed";
    }
}