import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import com.yourpackage.CustomUserDetails; // Replace with your actual package

public class YourController7 {

    @PutMapping(value = "change/property")
    public void changeProperty(@RequestParam Long propertyid, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
        // Add your implementation here
    }
}