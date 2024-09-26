import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp639 {
    public static void main(String[] args) {
        // Spring Boot application entry point would be here
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_DEVELOPER')")
    @RequestMapping(value = "/api/v1/system", method = RequestMethod.GET)
    public String system() {
        return "System endpoint accessed";
    }

    @PreAuthorize("hasAnyRole('ROLE_STAFF', 'ROLE_ADMIN')")
    @RequestMapping(value = "/api/v1/contactUs", method = RequestMethod.GET)
    public String contactUs() {
        return "Contact Us endpoint accessed";
    }
}