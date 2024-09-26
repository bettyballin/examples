import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import com.vaadin.ui.Label;

public class UserUtils {
    public static String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null; // or some default value if not logged in
    }

    public static void main(String[] args) {
        String currentUsername = getCurrentUsername();
        if (currentUsername != null) {
            // You can now use this username in your UI to display it
            Label welcomeLabel = new Label("Logged in as: " + currentUsername);
            // Add it to your layout or use it as needed in your UI
        }
    }
}