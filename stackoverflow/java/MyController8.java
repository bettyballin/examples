import org.springframework.ui.ModelMap;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;

public class MyController8 {

    @ModelAttribute
    public void load(ModelMap model, @AuthenticationPrincipal CustomUser user) {
        if (user != null) {
            long userId = user.getId();
            // Query database with userId and add data to model
        }
    }
    
    // Assuming CustomUser is a class that has a getId method.
    public static class CustomUser {
        public long getId() {
            // implementation here
            return 0L;
        }
    }
}