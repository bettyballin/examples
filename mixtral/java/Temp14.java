import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class Temp14 {

    @Autowired
    private HttpServletRequest request;

    public static void main(String[] args) {
        // Your code here
    }

    @PreAuthorize("hasRole('ROLE_USER') and @temp14.hasSecureConnection(true)")
    public String securePage() {
        return "Secure Page Accessed";
    }

    // Custom SpEL function to check secure connection
    public boolean hasSecureConnection(boolean isSecured) {
        return (request.isSecure() == isSecured);
    }
}