import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.vaadin.ui.Button;
import com.vaadin.ui.Layout;

public class YourClass {
    public void addEditUsersButton(Layout layout) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
            layout.addComponent(new Button("Edit users"));
        }
    }
}