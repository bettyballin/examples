import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.GridLayout;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@SpringView(name = SecureView.NAME, cached = true)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class SecureView extends GridLayout implements View {
    public static final String NAME = "secureView";

    public SecureView() {
        // Initialize your view components here
    }
    
    @Override
    public void enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent event) {
        // Handle the view entry, e.g., update the components according to parameters if any
    }
}